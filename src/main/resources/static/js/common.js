
var page=["index","shopCar"];
$(function () {

    if (localStorage.getItem("token")){
        var h = "<li class=\"dropdown\"><a href=\"/p/shopCar\" title=\"用户中心\">用户中心</a></li>";
        $("#user1").append(h);
    }
    page.forEach(function (value) {
        if (window.location.href.indexOf(value) != -1){
            $("#"+value).addClass("active");
        }
    })

    $("#site-loader").delay(1000).fadeOut("slow");
});

var shopCar = {
    KEY:"shopCar",
    add:function (id) {
        method.ajax({
            type:"POST",
            url:"/shopCart/add",
            data:{"carId":id},
            success:function (data) {
                if (data.errCode="200") {
                    alert("添加成功");
                    // var list = shopCar.getIdList();
                    // // 2.0 将obj 追加到list中
                    // list.push(id);
                    // // 3.0 将list数据转出json字符串存储到localStorage中
                    // localStorage.setItem(shopCar.KEY,JSON.stringify(list))
                    // alert("购物车已有"+list.length+"个:"+list)
                }else{
                    alert("添加失败");
                }

            }
        });

    },
    getIdList:function () {
        var lsSting = localStorage.getItem(shopCar.KEY);
        var list = [];
        if(lsSting){
            list = JSON.parse(lsSting);
        }
        return list;
    },
    getCars:function () {
        // application/json
        var list = new Array();
        method.ajax({
            url:"/shopCart/list",
            //data:{"ids":shopCar.idString()},
            type : "post",
            async : false,
            contentType: "application/x-www-form-urlencoded",
            success : function (data) {
                console.log(data);
                if (data.errCode == "200"){
                    list = data.data;
                }
            }
        })
        return list;
    },
    remove:function (id) {
        console.log("删除id:"+id)
        method.ajax({
            url:"/shopCart/delete",
            data:{"carId":id},
            type:"post",
            success:function (data) {
                if (data.errCode=="200" && data.data){
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
            }
        })
    },
    redu:function (id) {
        method.ajax({
            type:"POST",
            url:"/shopCart/redu",
            data:{"carId":id},
            success:function (data) {
                if (data.errCode=="200" && data.data){
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
            }
        });
    }
}
var method = {
    // 获取url参数
    getUrlParams: function(name) {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
            return  r[2];
        else
            return "";
    },
    ajax:function (settings) {
        var that = this;
        var defPar = {
            type: 'get',
            url: '',
            dataType: 'json',
            data: {},
            async: false,
            cache: false,
            contentType: "application/x-www-form-urlencoded",
            //contentType: "application/json",
            success: function(res) {
            },
            error: function(res) {}
        };
        $.extend(defPar, settings);
        $.ajax({
            headers: {"token":localStorage.getItem("token")},
            type: defPar.type,
            url: defPar.url,
            // dataType: defPar.dataType,
            data: defPar.data,
            async: defPar.async,
            cache: defPar.cache,
            contentType: defPar.contentType,
            success: function (res) {
                if (res.errCode=="400"){
                    localStorage.setItem("oldPage",window.location.href);
                    window.location.href="/p/login";
                    return;
                }else if (res.errCode == "500"){
                    alert(res.errMsg);
                } else{
                    defPar.success(res);
                }

            },
            error: function (res) {
            }
        });
    },
    getCarById:function (id) {
        var car = {};
        method.ajax({
            url:"/car/id",
            type:"get",
            async: false,
            data:{"id":id},
            success:function (data) {
                car = data;
            }
        });
        return car;
    }
}


