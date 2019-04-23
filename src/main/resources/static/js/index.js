var type = "";
var cars;

$(function () {
    //初始化类型
    initBrand();
    $.ajax({
        url:"/car/list",
        data:{"price":1},
        type : "get",
        async : false,
        contentType: "application/json",
        success : function (data) {
            cars = data.data;
        }
    });

    $("#site-loader").delay(1000).fadeOut("slow");
    $("#queryBtn").click(query);
    $(".selectType").click(function () {
        selectType($(this));
    });
    query();



});

function query() {
    $("#cars").empty();
    var carrs1 = cars;
    var price = $("#price").val();
    var brand = $("#brand").val();
    console.log("查找类型:"+type+",品牌:"+$("#brand").val()+",价格区间:"+$("#price").val());
    carrs1 = $.grep(cars,function(n,i){
        var p = n.price;
        if (price != ""){
            var sp = price.split(",");
            if (sp[0]>p || sp[1]<p){
                return true;
            }
        }
        if (brand!="" && brand !=n.carBrand){
            return true;
        }
        if (type!="" && type !=n.carType){
            return true;
        }
        return false;
    },true);
    carrs1.forEach(function (value, index) {
        initCar(value);
    })
}
//按类型选择
function selectType(o) {
    if ($(o).hasClass("checkType")){
        type = "";
        $(".selectType").removeClass("checkType");
        return;
    }
    $(".selectType").removeClass("checkType");
    $(o).addClass("checkType");
    type = $(o).text();
}

function initCar(car) {
    var h = "<div id=\""+car.id+"\" class=\"col-sm-6 col-md-4\">\n" +
        "                        <div class=\"thumbnail\">\n" +
        "                            <img src=\""+car.carImage+"\" alt=\"...\">\n" +
        "                            <div class=\"caption\">\n" +
        "                                <h3>"+car.carName+"</h3>\n" +
        "                                <p>"+car.carType+",可乘坐 "+car.carRide+"人</p>\n" +
        "                                <p>价格:"+car.price+"元/天</p>\n" +
        "                                <p>" +
        "<a href=\"javascript:shopCar.add('"+car.id+"')\" class=\"btn btn-primary\" role=\"button\">加入购物车</a>" +
        " <a href=\"/carDetail.html?id="+car.id+"\" class=\"btn btn-default\" role=\"button\">查看详情</a></p>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                    </div>";
    $("#cars").append(h);

}

//初始化汽车品牌
function initBrand() {
    $.ajax({
        url:"/car/brands",
        data:{},
        type : "get",
        async : false,
        contentType: "application/json",
        success : function (data) {
            $("#brand").empty();
            var h = "<option value=''>请选择品牌</option>";
            $("#brand").append(h);
            data.data.forEach(function (value) {
                var h = "<option value='"+value+"'>"+value+"</option>";
                $("#brand").append(h);
            })
        }
    });
}

