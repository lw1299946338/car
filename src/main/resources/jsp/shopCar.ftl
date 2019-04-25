<!DOCTYPE html>
<#include "header.ftl"/>
<link rel="stylesheet" href="/shopCar/css/reset.css">
    <link rel="stylesheet" href="/shopCar/css/carts.css">
<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<div class="main-container">
    <!-- Header Section -->
    <#include "banner.ftl"/>
    <main>
        <!-- Page Banner -->
        <div class="container-fluid no-padding page-banner">
            <div class="padding-90"></div>
            <!-- Container -->
            <div class="container">
                <h3>购物车</h3>
                <ol class="breadcrumb">
                    <li><a href="/p/index">首页</a></li>
                    <li class="active">购物车</li>
                </ol>
            </div><!-- Container /- -->
            <div class="padding-100"></div>
        </div><!-- Page Banner /- -->

        <div class="padding-30"></div>
        <div id="noCar" class="hide">
            <div class="jumbotron text-center">
                <h1>您的购物车空空如也....</h1>
                <p>...</p>
                <p><a class="btn btn-primary btn-lg" href="/p/index" role="button">去看看</a></p>
            </div>
        </div>
        <section id="haveCar" class="cartMain">
            <div class="cartMain_hd">
                <ul class="order_lists cartTop">
                    <li class="list_chk">
                        <!--所有商品全选-->
                        <!--<input type="checkbox" id="all" class="whole_check">-->
                        <!--<label for="all"></label>-->
                        <!--全选-->
                        选择
                    </li>
                    <li class="list_con">商品信息</li>
                    <li class="list_info">商品参数</li>
                    <li class="list_price">单价</li>
                    <li class="list_amount">数量</li>
                    <li class="list_sum">金额</li>
                    <li class="list_op">操作</li>
                </ul>
            </div>
            <div class="cartBox">
                <div id="cars" class="order_content">

                </div>
            </div>

            <!--底部-->
            <div class="bar-wrapper">
                <div class="bar-right">
                    <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
                    <div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>
                    <div class="calBtn"><a id="jiesuan" href="javascript:void (0);">结算</a></div>
                </div>
            </div>
        </section>
        <section class="model_bg"></section>
        <section class="my_model" style="height: 139px;">
            <p class="title">删除宝贝<span class="closeModel">X</span></p>
            <p>您确认要删除该宝贝吗？</p>
            <div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
        </section>

    </main>


    <!-- Footer Section -->
    <#include "footer.ftl"/>

</div>
<script src="/shopCar/js/carts.js"></script>
</body>
</html>
