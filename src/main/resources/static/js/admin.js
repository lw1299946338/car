$(function () {
    admin.initCar();
    $("#carAdmin").click(admin.initCar);
    $("#orderAdmin").click(admin.initOrder);
    $("#driverAdmin").click(admin.initDriver);
    if (!method.isAdmin()){
        window.location.href="/p/index";
    }

    $("#addDriver").click(function () {
        admin.addDriver("")
    });
    $("#saveDriverBtn").click(admin.saveDriver);

});
var admin = {

    init:function(){

    },
    initCar:function () {
        method.ajax({
            url:"/car/all",
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
                            "<td>"+car.city+"</td>\n" +
                            "<td>"+(car.status=="1"?"启用":"禁用")+"</td>\n" +
                            "<td>";
                            if(car.status=="1"){
                                html+="<input onclick=\"admin.carStatus('"+car.id+"','1')\" class=\"btn btn-default\" type=\"button\" value=\"禁用\">";
                            }else{
                                html+="<input onclick=\"admin.carStatus('"+car.id+"','0')\" class=\"btn btn-default\" type=\"button\" value=\"启用\">";
                            }
                            "</td>\n" +
                            "</tr>";
                    })
                    $("#carTable").html(html);
                }
            }
        })
    },
    carStatus:function(id,status){
        var s = status=="1"?"禁用":"启用";
        method.alertCheck("是否"+s+"该辆车",null,function () {
            //alert(id+status);
            method.ajax({
                url:"/car/status",
                type:"get",
                data:{"id":id,"status":status=="1"?"0":"1"},
                success:function (data) {
                    if (data.errCode=="200" && data.data){
                        method.alertSuccess("更新成功","");
                    } else {
                        method.alertError("更新失败","");
                    }
                    admin.initCar();
                }
            })

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
                            order.payNumber = 0;
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
                            "<td>"+
                            "<input class=\"btn btn-default\" type=\"button\" value=\"删除\">"+
                            "</td>\n" +
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
                            "<td>"+
                            "<input onclick=\"admin.addDriver('"+driver.id+"')\" class=\"btn btn-default\" type=\"button\" value=\"编辑\">"+
                            "</td>\n" +
                            "</tr>";
                    })
                    $("#driverTable").html(html);
                }
            }
        })
    },
    addDriver:function (id) {
        if (id == ""){
            document.getElementById("addDriverForm").reset();
            $("#myModalLabel").text("新建司机");
            $("#driverModel").modal().show();
            return;
        }
        method.ajax({
            url:"/driver/id",
            data:{"id":id},
            type:"get",
            success:function (data) {
                if (data.errCode == "200"){
                    var driver = data.data;
                    $("#myModalLabel").text("编辑司机");
                    $("#addDriverForm").find("input[name='id']").val(driver.id);
                    $("#addDriverForm").find("input[name='driverPhone']").val(driver.driverPhone);
                    $("#addDriverForm").find("input[name='driverName']").val(driver.driverName);
                    $("#addDriverForm").find("select[name='driverGender']").val(driver.driverGender);
                    $("#addDriverForm").find("input[name='driverAge']").val(driver.driverAge);
                    $("#addDriverForm").find("input[name='driverYear']").val(driver.driverYear);
                    $("#addDriverForm").find("input[name='driverCard']").val(driver.driverCard);
                    $("#addDriverForm").find("input[name='driverLevel']").val(driver.driverLevel);
                    $("#addDriverForm").find("input[name='driverCity']").val(driver.driverCity);
                    $("#driverModel").modal().show();
                }
            }
        })
    },
    saveDriver:function () {
        method.ajax({
            url:"/driver/update",
            data:$("#addDriverForm").serialize(),
            type:"get",
            success:function (data) {
                if (data.errCode == "200"){
                    alert("保存成功");
                    admin.initDriver();
                    $("#aDriverBtn").click();
                }
            }
        })
    }
};