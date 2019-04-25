/**
 * Created by Administrator on 2017/5/24.
 */
var checkCars = new Array();
$(function () {
    
    $("#jiesuan").click(jiesuan);

    initShopCar();

    //全局的checkbox选中和未选中的样式
    var $allCheckbox = $('input[type="checkbox"]'),     //全局的全部checkbox
        $wholeChexbox = $('.whole_check'),
        $cartBox = $('.cartBox'),                       //每个商铺盒子
        $shopCheckbox = $('.shopChoice'),               //每个商铺的checkbox
        $sonCheckBox = $('.son_check');                 //每个商铺下的商品的checkbox
    $allCheckbox.click(function () {
        if ($(this).is(':checked')) {
            $(this).next('label').addClass('mark');
        } else {
            $(this).next('label').removeClass('mark')
        }
    });

    //===============================================全局全选与单个商品的关系================================
    $wholeChexbox.click(function () {
        var $checkboxs = $cartBox.find('input[type="checkbox"]');
        if ($(this).is(':checked')) {
            $checkboxs.prop("checked", true);
            $checkboxs.next('label').addClass('mark');
        } else {
            $checkboxs.prop("checked", false);
            $checkboxs.next('label').removeClass('mark');
        }
        totalMoney();
    });


    $sonCheckBox.each(function () {
        $(this).click(function () {
            if ($(this).is(':checked')) {
                //判断：所有单个商品是否勾选
                var len = $sonCheckBox.length;
                var num = 0;
                $sonCheckBox.each(function () {
                    if ($(this).is(':checked')) {
                        num++;
                    }
                });
                if (num == len) {
                    $wholeChexbox.prop("checked", true);
                    $wholeChexbox.next('label').addClass('mark');
                }
            } else {
                //单个商品取消勾选，全局全选取消勾选
                $wholeChexbox.prop("checked", false);
                $wholeChexbox.next('label').removeClass('mark');
            }
        })
    })

    //=======================================每个店铺checkbox与全选checkbox的关系/每个店铺与其下商品样式的变化===================================================

    //店铺有一个未选中，全局全选按钮取消对勾，若店铺全选中，则全局全选按钮打对勾。
    $shopCheckbox.each(function () {
        $(this).click(function () {
            if ($(this).is(':checked')) {
                //判断：店铺全选中，则全局全选按钮打对勾。
                var len = $shopCheckbox.length;
                var num = 0;
                $shopCheckbox.each(function () {
                    if ($(this).is(':checked')) {
                        num++;
                    }
                });
                if (num == len) {
                    $wholeChexbox.prop("checked", true);
                    $wholeChexbox.next('label').addClass('mark');
                }

                //店铺下的checkbox选中状态
                $(this).parents('.cartBox').find('.son_check').prop("checked", true);
                $(this).parents('.cartBox').find('.son_check').next('label').addClass('mark');
            } else {
                //否则，全局全选按钮取消对勾
                $wholeChexbox.prop("checked", false);
                $wholeChexbox.next('label').removeClass('mark');

                //店铺下的checkbox选中状态
                $(this).parents('.cartBox').find('.son_check').prop("checked", false);
                $(this).parents('.cartBox').find('.son_check').next('label').removeClass('mark');
            }
            totalMoney();
        });
    });


    //========================================每个店铺checkbox与其下商品的checkbox的关系======================================================

    //店铺$sonChecks有一个未选中，店铺全选按钮取消选中，若全都选中，则全选打对勾
    $cartBox.each(function () {
        var $this = $(this);
        var $sonChecks = $this.find('.son_check');
        $sonChecks.each(function () {
            $(this).click(function () {
                if ($(this).is(':checked')) {
                    //判断：如果所有的$sonChecks都选中则店铺全选打对勾！
                    var len = $sonChecks.length;
                    var num = 0;
                    $sonChecks.each(function () {
                        if ($(this).is(':checked')) {
                            num++;
                        }
                    });
                    if (num == len) {
                        $(this).parents('.cartBox').find('.shopChoice').prop("checked", true);
                        $(this).parents('.cartBox').find('.shopChoice').next('label').addClass('mark');
                    }

                } else {
                    //否则，店铺全选取消
                    $(this).parents('.cartBox').find('.shopChoice').prop("checked", false);
                    $(this).parents('.cartBox').find('.shopChoice').next('label').removeClass('mark');
                }
                totalMoney();
            });
        });
    });


    //=================================================商品数量==============================================
    //加
    var $plus = $('.plus'),
        //减
        $reduce = $('.reduce'),
        $all_sum = $('.sum');
    //加
    $plus.click(function () {
        shopCar.add($(this).parents(".order_lists").attr("id"));
        var $inputVal = $(this).prev('input'),
            $count = parseInt($inputVal.val())+1,
            $obj = $(this).parents('.amount_box').find('.reduce'),
            $priceTotalObj = $(this).parents('.order_lists').find('.sum_price'),
            $price = $(this).parents('.order_lists').find('.price').html(),  //单价
            $priceTotal = $count*parseInt($price.substring(1));
        $inputVal.val($count);
        //console.log($inputVal.val());
        $priceTotalObj.html('￥'+$priceTotal);
        if($inputVal.val()>1 && $obj.hasClass('reSty')){
            $obj.removeClass('reSty');
        }
        totalMoney();
    });

    //减
    $reduce.click(function () {
        shopCar.redu($(this).parents(".order_lists").attr("id"));
        var $inputVal = $(this).next('input'),
            $count = parseInt($inputVal.val())-1,
            $priceTotalObj = $(this).parents('.order_lists').find('.sum_price'),
            $price = $(this).parents('.order_lists').find('.price').html(),  //单价
            $priceTotal = $count*parseInt($price.substring(1));
        if($inputVal.val()>1){
            $inputVal.val($count);
            $priceTotalObj.html('￥'+$priceTotal);
        }
        if($inputVal.val()==1 && !$(this).hasClass('reSty')){
            $(this).addClass('reSty');
        }
        //console.log($inputVal.val());
        totalMoney();
    });

    $all_sum.keyup(function () {
        var $count = 0,
            $priceTotalObj = $(this).parents('.order_lists').find('.sum_price'),
            $price = $(this).parents('.order_lists').find('.price').html(),  //单价
            $priceTotal = 0;
        if($(this).val()==''){
            $(this).val('1');
        }
        $(this).val($(this).val().replace(/\D|^0/g,''));
        $count = $(this).val();
        $priceTotal = $count*parseInt($price.substring(1));
        $(this).attr('value',$count);
        $priceTotalObj.html('￥'+$priceTotal);
        totalMoney();
    })

    //======================================移除商品========================================

    var $order_lists = null;
    var $order_content = '';
    var $order_id = '';
    //点击删除按钮时
    $('.delBtn').click(function () {
        $order_lists = $(this).parents('.order_lists');
        $order_content = $order_lists.parents('.order_content');
        $order_id =$(this).parents('.order_lists').attr("id");
        $('.model_bg').fadeIn(300);
        $('.my_model').fadeIn(300);
    });

    //关闭模态框
    $('.closeModel').click(function () {
        closeM();
    });
    $('.dialog-close').click(function () {
        closeM();
    });
    function closeM() {
        $('.model_bg').fadeOut(300);
        $('.my_model').fadeOut(300);
    }
    //确定按钮，移除商品
    $('.dialog-sure').click(function () {
        $order_lists.remove();
        if($order_content.html().trim() == null || $order_content.html().trim().length == 0){
            console.log($($order_content).attr("id"));
            $order_content.parents('.cartBox').remove();
        }
        shopCar.remove($order_id);
        closeM();
        $sonCheckBox = $('.son_check');
        totalMoney();
    })

    //======================================总计==========================================

    function totalMoney() {
        var total_money = 0;
        var total_count = 0;
        var calBtn = $('.calBtn a');
        $sonCheckBox.each(function () {
            if ($(this).is(':checked')) {
                var goods = parseInt($(this).parents('.order_lists').find('.sum_price').html().substring(1));
                var num =  parseInt($(this).parents('.order_lists').find('.sum').val());
                total_money += goods;
                total_count += num;
            }
        });
        $('.total_text').html('￥'+total_money);
        $('.piece_num').html(total_count);

        // console.log(total_money,total_count);

        if(total_money!=0 && total_count!=0){
            if(!calBtn.hasClass('btn_sty')){
                calBtn.addClass('btn_sty');
            }
        }else{
            if(calBtn.hasClass('btn_sty')){
                calBtn.removeClass('btn_sty');
            }
        }
    }


});

function initShopCar() {
    var cars = shopCar.getCars();
    checkCars = cars;
    $("#cars").empty();
    cars.forEach(function(car,index) {
        var html = addHtml(car);
        $("#cars").append(html);
    });
    if (cars.length<1){
        $("#noCar").removeClass("hide");
        $("#haveCar").addClass("hide");
    }else{
        $("#haveCar").removeClass("hide");
        $("#noCar").addClass("hide");
    }

}

function addHtml(car) {
    var ht = "<ul class=\"order_lists\" id=\""+car.id+"\">\n" +
        "<li class=\"list_chk\">\n" +
        "<input type=\"checkbox\" id=\"checkbox_"+car.id+"\" class=\"son_check\">\n" +
        " <label for=\"checkbox_"+car.id+"\"></label>\n" +
        "</li>\n" +
        "<li class=\"list_con\">\n" +
        "<div class=\"list_img\"><a href=\"javascript:carInfo('"+car.id+"');\"><img src=\""+car.carImage+"\" alt=\"\"></a></div>\n" +
        " <div class=\"list_text\"><a href=\"javascript:carInfo('"+car.id+"');\">"+car.carName+"</a></div>\n" +
        "</li>\n" +
        "<li class=\"list_info\">\n" +
        "<p>"+car.carType+",可乘坐 "+car.carRide+"人</p>\n" +
        "<p>价格:"+car.price+"元/天</p>\n" +
        "</li>\n" +
        "<li class=\"list_price\">\n" +
        "<p class=\"price\">￥"+car.price+"</p>\n" +
        "</li>\n" +
        "<li class=\"list_amount\">\n" +
        "<div class=\"amount_box\">\n" +
        " <a href=\"javascript:;\" class=\"reduce reSty\">-</a>\n" +
        "<input type=\"text\" value=\""+car.count+"\" class=\"sum\">\n" +
        "<a href=\"javascript:;\" class=\"plus\">+</a>\n" +
        "</div>\n" +
        "</li>\n" +
        "<li class=\"list_sum\">\n" +
        "<p class=\"sum_price\">￥"+car.price*car.count+"</p>\n" +
        "</li>\n" +
        "<li class=\"list_op\">\n" +
        "<p class=\"del\"><a href=\"javascript:;\" class=\"delBtn\">移除商品</a></p>\n" +
        "</li>\n" +
        "</ul>";
    return ht;
}

function carInfo(id) {
    window.location.href="//p/carDetail?id="+id;
}

function jiesuan() {
    var checks = $("#cars").find(".mark");
    //console.log(checks);
    var list = new Array();

    for (var x = 0;x<checks.length;x++) {
        var attr = $(checks[x]).attr("for");
        var id = attr.replace("checkbox_","");
        var count = $("#"+id).find(".sum").val();
        var orderText = id+":"+count;
        list.push(orderText);
    }
    var orderText = list.join(",");

    var x = new Array();
    checkCars.forEach(function (value,index) {
        if (orderText.indexOf(value.id) != -1){
            x.push(value);
        }
    });
    localStorage.setItem("createOrder",JSON.stringify(x));
    //console.log(orderText);
    window.location.href="/p/createOrder?text="+orderText;
}

