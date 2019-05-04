$(function () {
    user.initOrder();
    $("#userDetail").click(user.init);
    $("#userOrder").click(user.initOrder);
    if (localStorage.getItem("token") ==null){
        window.location.href="/p/index";
    }
    $("#addDriver").click(function () {
        admin.addDriver("")
    });
    $("#saveDriverBtn").click(admin.saveDriver);

});
var payOrderId;
var user = {
    payOrderId : "",
    init:function(){
        var user = JSON.parse(localStorage.getItem("user"));
        $(".name").html(user.name);
        $(".user_name").html(user.userName);
        $(".phone").html(user.phone);
        $(".paypassword").html("******");
    },
    initOrder:function () {
        method.ajax({
            url:"/order/list",
            type:"POST",
            async:true,
            success:function (data) {
                if (data.errCode == "200"){
                    var orders = data.data;
                    var html = "";
                    orders.forEach(function (order,index) {
                        var status = false;
                        if (order.payStatus == "0"){
                            order.payStatus="<span class=\"btn btn-danger active\">未支付</span>";
                            order.payNumber = 0;
                            order.payTime = "";
                            order.returnTime = "";
                            status = true;
                        } else if (order.payStatus == "1") {

                            order.payStatus="<span class=\"btn btn-warning active\">待取车</span>";
                            order.returnTime = "";
                        }else if (order.payStatus == "2") {

                            order.payStatus="<span class=\"btn btn-primary active\">使用中</span>";
                            order.returnTime = "";
                        }else if (order.payStatus == "3") {
                            order.payStatus="<span class=\"btn btn-success active\">已还车</span>";
                        }

                        html+="<tr>\n" +
                            "<th scope=\"row\">"+index+"</th>\n" +
                            "<td>"+order.orderNumber+"</td>\n" +
                            "<td>"+order.payableNumber+"</td>\n" +
                            "<td>"+order.payStatus+"</td>\n" +
                            "<td>"+order.payNumber+"</td>\n" +
                            "<td>"+ method.Object.notEmpty(order.payTime)+"</td>\n" +
                            "<td>"+order.createTime+"</td>\n" +
                            "<td>"+ method.Object.notEmpty(order.backTime)+"</td>\n" +
                            "<td>"+ method.Object.notEmpty(order.returnTime)+"</td>\n" +
                            "<td>";
                        if(status){
                            html+= "<input class=\"btn btn-default\" onclick=\"user.payModel('"+order.id+"')\"  type=\"button\" value=\"去支付\">";
                        }else{
                            html+= "<input class=\"btn btn-default disabled\" type=\"button\" value=\"去支付\">";
                        }

                        html+="</td>\n" +
                            "</tr>";
                    })
                    $("#orderTable").html(html);
                }
            }
        })
    },
    payModel:function(id){
        user.payOrderId = id;
        $("#pay_password").val("");
        $("#payModel").modal("show");
    },
    pay:function () {
        if ($("#pay_password").val() == JSON.parse(localStorage.getItem("user")).payPassword){
            method.ajax({
                url:"/order/pay",
                type:"get",
                async:false,
                data:{"id":user.payOrderId},
                success:function (data) {
                    if (data.errCode=="200"){
                        method.alertSuccess("支付成功","");
                    } else {
                        method.alertError("支付失败","");
                    }
                    $("#payModel").modal("hide");
                }
            });
        } else{
            method.alertError("支付失败","支付密码错误");
        }
        user.initOrder();

    }

};