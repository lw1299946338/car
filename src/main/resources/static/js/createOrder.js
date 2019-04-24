
$(function () {
    order.init();
});
var order= {
    init: function () {
        var carIds = method.getUrlParams("text").split(",");

        var cars = new Array()
        carIds.forEach(function (value) {
            var split = value.split(":");
            var carById = method.getCarById(split[0]);
            carById.count=split[1];
            cars.push(carById)
        });
        $("#cars").empty();
        cars.forEach(function (car, index) {
            var html = order.addHtml(car);
            $("#cars").append(html);
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
            "<li class=\"list_price\">\n" +
            "<p class=\"price\">单价：￥" + car.price + "</p>\n" +
            "</li>\n" +
            "<li class=\"list_amount\">\n" +
            "<div class=\"amount_box\">\n" +
            car.count+
            "</div>\n" +
            "</li>\n" +
            "<li class=\"list_sum\">\n" +
            "<p class=\"sum_price\">总价：￥" + car.price * car.count + "</p>\n" +
            "</li>\n" +
            "</ul>";
        return ht;
    }
}
