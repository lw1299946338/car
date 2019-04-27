<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en" class=""><!--<![endif]-->
<#include "header.ftl"/>
<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<div class="main-container">
    <!-- Header Section -->
    <#include "banner.ftl"/>s
    <main>

        <!-- Page Banner -->
        <div class="container-fluid no-padding page-banner">
            <div class="padding-90"></div>
            <!-- Container -->
            <div class="container">
                <h3>登录</h3>
                <ol class="breadcrumb">
                    <li><a href="index.html">首页</a></li>
                    <li class="active">登录</li>
                </ol>
            </div><!-- Container /- -->
            <div class="padding-100"></div>
        </div><!-- Page Banner /- -->

        <!--<div class="section-padding"></div>-->

        <!-- Contact Section -->
        <div class="container-fluid no-padding contact-section">
            <!-- Container -->
            <div class="container">
                <h3></h3>
                <form id="loginForm" class="row">
                    <div class="form-group col-md-6 col-sm-6 col-xs-12">
                        <input type="text" name="userName" id="userName" required="" placeholder="用户名" class="form-control">
                        <input type="password" name="password" id="password" required="" placeholder="登录密码" class="form-control">
                    </div>
                    <!--<div class="form-group col-md-6 col-sm-6 col-xs-12">-->
                        <!--<input type="email" name="contact-email" id="input_email" required="" placeholder="Email address" class="form-control">-->
                        <!--<input type="email" name="contact-phone" id="input_phone" required="" placeholder="Phone" class="form-control">-->
                    <!--</div>-->
                    <!--<div class="form-group col-md-12 col-sm-12 col-xs-12">-->
                        <!--<textarea name="contact-message" id="textarea_message" placeholder="Write message" rows="4" class="form-control"></textarea>-->
                    <!--</div>-->
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <button id="btn_submit" type="submit" title="登录">登录</button>
                    </div>

                </form>
            </div>
        </div>

        <div class="padding-100"></div>
        <div class="padding-30"></div>
    </main>


    <!-- Footer Section -->
    <#include "footer.ftl"/>
</div>


<script type="application/javascript">
    $( "#btn_submit" ).on( "click", function(event) {
        event.preventDefault();
        var mydata = $("#loginForm").serialize();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/user/login",
            data: mydata,
            success: function(data) {
                console.log(data);
                if (data.errCode == "200" && data.data!=""){
                    localStorage.setItem("token",data.data);
                    var item = localStorage.getItem("oldPage");
                    if (item){
                        localStorage.removeItem("oldPage");
                        window.location.href = item;
                    }else{
                        window.location.href = "/index.html";
                    }
                }else{
                    alert(data.errMsg);
                }
            },
            error: function(xhr, textStatus, errorThrown) {
                //alert(textStatus);
            }
        });
        return false;
    });/* Quick Contact Form /- */
</script>
</body>
</html>
