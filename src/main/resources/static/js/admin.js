$(function () {
    admin.initCar();
    $("#carAdmin").click(admin.initCar());
    $("#orderAdmin").click(admin.initCar());
    $("#driverAdmin").click(admin.initCar());
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
                            "<th scope=\"row\">"+index+1+"</th>\n" +
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
            url:"/order/list",
            type:"get",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var cars = data.data;
                    var html = "";
                    cars.forEach(function (car,index) {
                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+1+"</th>\n" +
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
    initDriver:function () {
        method.ajax({
            url:"/driver/list",
            type:"get",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var cars = data.data;
                    var html = "";
                    cars.forEach(function (car,index) {
                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+1+"</th>\n" +
                            "<td>"+car.carBrand+"</td>\n" +
                            "<td>"+car.carName+"</td>\n" +
                            "<td>"+"禁用"+"</td>\n" +
                            "</tr>";
                    })
                    $("#carTable").html(html);
                }
            }
        })
    }
};