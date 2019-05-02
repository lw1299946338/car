$(function () {
    user.initOrder();
    $("#userDetail").click(user.init);
    $("#userOrder").click(user.initOrder);
    if (!method.isAdmin()){
        window.location.href="/p/index";
    }

    $("#addDriver").click(function () {
        admin.addDriver("")
    });
    $("#saveDriverBtn").click(admin.saveDriver);

});
var user = {
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
                            order.payStatus ="未支付";
                            order.payNumber = 0;
                            order.payTime = "";
                            order.returnTime = "";
                            status = true;
                        } else if (order.payStatus == "1") {

                            order.payStatus ="已支付";
                            order.returnTime = "";
                        }else{
                            order.payStatus = "已还车";
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
                            html+= "<input class=\"btn btn-default\"  type=\"button\" value=\"去支付\">";
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
    }

};