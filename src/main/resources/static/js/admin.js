$(function () {
    admin.initCar();
    $("#carAdmin").click(admin.initCar);
    $("#orderAdmin").click(admin.initOrder);
    $("#driverAdmin").click(admin.initDriver);
    if (!method.isAdmin()){
        window.location.href="/p/index";
    }
});
var admin = {

    init:function(){

    },
    initCar:function () {
        method.ajax({
            url:"/car/list",
            type:"get",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var cars = data.data;
                    var html = "";
                    cars.forEach(function (car,index) {
                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+"</th>\n" +
                            "<td>"+car.carBrand+"</td>\n" +
                            "<td>"+car.carName+"</td>\n" +
                            "<td>"+"禁用"+"</td>\n" +
                            "</tr>";
                    })
                    $("#carTable").html(html);
                }
            }
        })
    },
    initOrder:function () {
        method.ajax({
            url:"/order/all",
            type:"get",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var orders = data.data;
                    var html = "";
                    orders.forEach(function (order,index) {
                        if (order.payStatus == "0"){
                            order.payStatus ="未支付";
                            order.payTime = "";
                            order.payableNumber = 0;
                            order.payTime = "";
                        } else{
                            order.payStatus ="已支付";
                        }
                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+"</th>\n" +
                            "<td>"+order.orderNumber+"</td>\n" +
                            "<td>"+order.payableNumber+"</td>\n" +
                            "<td>"+order.payStatus+"</td>\n" +
                            "<td>"+order.payNumber+"</td>\n" +
                            "<td>"+order.payTime+"</td>\n" +
                            "<td>"+order.createTime+"</td>\n" +
                            "<td>"+"禁用"+"</td>\n" +
                            "</tr>";
                    })
                    $("#orderTable").html(html);
                }
            }
        })
    },
    initDriver:function () {
        method.ajax({
            url:"/driver/list",
            type:"get",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var drivers = data.data;
                    var html = "";
                    drivers.forEach(function (driver,index) {
                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+"</th>\n" +
                            "<td>"+driver.driverName+"</td>\n" +
                            "<td>"+driver.driverPhone+"</td>\n" +
                            "<td>"+"禁用"+"</td>\n" +
                            "</tr>";
                    })
                    $("#driverTable").html(html);
                }
            }
        })
    }
};