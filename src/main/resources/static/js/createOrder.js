
$(function () {
    order.init();
    $("#createOrder").click(order.create);
});
var drivers = [];

method.ajax({
    url:"/driver/list",
    data:{},
    type:"get",
    success:function (data) {
        if (data.errCode == "200") {
            drivers = data.data;
        }
    }
});

var order= {
    text:"",
    init: function () {
        var carIds = method.getUrlParams("text").split(",");
        var cars = JSON.parse(localStorage.getItem("createOrder"));
        if (carIds == null || carIds == ""){
            window.location.href="/index.html";
        }
        order.text=carIds;
        carIds.forEach(function (value,index) {
            var split = value.split(":");
            //var carById = method.getCarById(split[0]);
            cars[index].count=split[1];
        });




        $("#cars").empty();
        cars.forEach(function (car, index) {
            var html = order.addHtml(car);
            $("#cars").append(html);
        })
    },
    create:function(){

        method.ajax({
            type:"post",
            url:"/order/create",
            data:{"param":method.getUrlParams("text")},
            success:function (data) {
                if (data.errCode == "200" && data.data){
                    alert("订单生成成功");
                    window.location.href="/p/index";
                } else {
                    alert("订单生成失败");
                }
            }
        })
    },
    addHtml: function (car) {
        var ht = "<ul class=\"order_lists\" id=\"" + car.id + "\">\n" +
            "<li class=\"list_con\">\n" +
            "<div class=\"list_img\"><a href=\"javascript:carInfo('" + car.id + "');\"><img src=\"" + car.carImage + "\" alt=\"\"></a></div>\n" +
            " <div class=\"list_text\"><a href=\"javascript:carInfo('" + car.id + "');\">" + car.carName + "</a></div>\n" +
            "</li>\n" +
            "<li class=\"list_info\">\n" +
            "<p>" + car.carType + ",可乘坐 " + car.carRide + "人</p>\n" +
            "<p>价格:" + car.price + "元/天</p>\n" +
            "</li>\n" +
            "<li class=\"list_price\">" +
            "<p class=\"price\">单价：￥" + car.price + "</p>" +
            "</li>\n" +
            "<li class=\"list_amount\" style=\"width: 96px;\">" +
            "<div class=\"amount_box\">租用" +
            car.count+
            "天</div>" +
            "</li>" +
            "<li class=\"list_sum\">选择司机" +
            "<select id='driver_"+car.id+"' class=\"form-control m-b\">" +
            "<option value=''>不选择司机</option> ";
        drivers.forEach(function (value) {
            ht +="<option value='"+value.id+"'>"+value.driverName+"</option>";
        });


        ht +="</select>" +
            "</li>\n"+
            "<li class=\"list_sum\">\n" +
            "<p class=\"sum_price\">总价：￥" + car.price * car.count + "</p>\n" +
            "</li>\n" +
            "</ul>";
        return ht;
    }
}

function carInfo(id) {
    window.location.href="/p/carDetail?id="+id;
}
