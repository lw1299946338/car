<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html lang="en" class=""><!--<![endif]-->
<#include "header.ftl">
<link rel="stylesheet" href="/shopCar/css/reset.css">
<link rel="stylesheet" href="/shopCar/css/carts.css">

<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<div class="main-container">
    <#include "banner.ftl">
    <main>

        <!-- Page Banner -->
        <#--<div class="container-fluid no-padding page-banner">-->
            <#--<div class="padding-90"></div>-->
            <#--<!-- Container &ndash;&gt;-->
            <#--<div class="container">-->
                <#--<h3>订单</h3>-->
                <#--<ol class="breadcrumb">-->
                    <#--<li><a href="/index.html">首页</a></li>-->
                    <#--<li><a href="//p/shopCar">购物车</a></li>-->
                <#--</ol>-->
            <#--</div><!-- Container /- &ndash;&gt;-->
            <#--<div class="padding-100"></div>-->
        <#--</div><!-- Page Banner /- &ndash;&gt;-->

        <div class="padding-30"></div>
        <section class="cartMain">
            <div class="cartMain_hd">
                <h3>商品信息</h3>
            </div>
            <div class="cartBox">
                <div id="cars" class="order_content">


                </div>

            </div>

            <div class="cartMain_hd">
                <h3>收货人信息</h3>
            </div>
            <div class="cartBox">
                <div class="order_content">
                    <div>
                        <hr>
                        <form class="form-horizontal" style="margin-top:5px;margin-left:150px;">
                            <div class="form-group">
                                <label for="username" class="col-sm-1 control-label">地址</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="username" placeholder="请输入收货地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="inputPassword3" placeholder="请输收货人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="confirmpwd" class="col-sm-1 control-label">电话</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="confirmpwd" placeholder="请输入联系方式">
                                </div>
                            </div>
                        </form>

                        <hr>
                    </div>
                </div>
            </div>


            <div class="cartMain_hd">
                <h3>选择支付方式</h3>
            </div>
            <div class="cartBox">
                <div class="order_content">
                    <div>
                        <div style="margin-top:5px;">
                            <h3>选择银行：</h3>
                            <hr>
                            <p>
                                <br>
                                <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked">工商银行
                                <img src="/bank_img/icbc.bmp" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="pd_FrpId" value="BOC-NET-B2C">中国银行
                                <img src="/bank_img/bc.bmp" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="pd_FrpId" value="ABC-NET-B2C">农业银行
                                <img src="/bank_img/abc.bmp" align="middle">
                                <br>
                                <br>
                                <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C">交通银行
                                <img src="/bank_img/bcc.bmp" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="pd_FrpId" value="PINGANBANK-NET">平安银行
                                <img src="/bank_img/pingan.bmp" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="pd_FrpId" value="CCB-NET-B2C">建设银行
                                <img src="/bank_img/ccb.bmp" align="middle">
                                <br>
                                <br>
                                <input type="radio" name="pd_FrpId" value="CEB-NET-B2C">光大银行
                                <img src="/bank_img/guangda.bmp" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C">招商银行
                                <img src="/bank_img/cmb.bmp" align="middle">
                                <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C">支付宝
                                <img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3464484560,1134962288&fm=58" align="middle">

                            </p>
                            <hr>

                            <hr>

                        </div>
                    </div>
                </div>
            </div>


            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                </div>
                <div class="btn-group" role="group">
                </div>
                <div class="btn-group" role="group">
                    <button type="button" id="createOrder" class="btn btn-danger">生成订单</button>
                </div>
            </div>

        </section>


    </main>


    <!-- Footer Section -->
    <#include "footer.ftl">

</div>
<script src="/js/createOrder.js"></script>
</body>
</html>
