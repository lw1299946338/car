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
        <div class="container-fluid no-padding page-banner">
            <div class="padding-90"></div>
            <!-- Container -->
            <div class="container">
                <h3>inventory</h3>
                <ol class="breadcrumb">
                    <li><a href="/index.html">Home</a></li>
                    <li class="active">商品详情</li>
                </ol>
            </div><!-- Container /- -->
            <div class="padding-100"></div>
        </div><!-- Page Banner /- -->

        <div class="section-padding"></div>

        <!-- Container -->
        <div class="container">
            <!-- Row -->
            <div class="row">
                <div class="col-md-8 col-sm-8 col-xs-12 content-area">
                    <div class="inventory-slider">
                        <ul id="imageGallery"  class="gallery">
                            <li data-thumb="">
                                <img src="" alt="Inventory" />
                            </li>
                            <li data-thumb="">
                                <img src="" alt="Inventory" />
                            </li>
                            <li data-thumb="">
                                <img src="" alt="Inventory" />
                            </li>
                        </ul>
                    </div>
                    <div class="inventroy-content inventory-single">
                        <h3 class="car_name"></h3>
                        <div class="inv-box">
                            <span>2016</span>
                            <span>310P</span>
                            <span>6速AT</span>
                            <span>2.0T</span>
                        </div>
                        <h4> 价格 <b class="car_price"></b><a id="addCar" href="javascript:void (0)" title="VIEW DETAILS">加入购物车<i class="fa fa-angle-double-right"></i></a></h4>
                    </div>

                </div>
                <div class="col-md-4 col-sm-4 col-xs-12 widget-area">
                    <aside class="widget widget_specifiaction">
                        <h3 class="widget-title">Specifications</h3>
                        <div class="specifications-content">
                            <p><span>Year:</span>2019</p>
                            <p><span>名称:</span><b class="car_name">Aston-Martin</b></p>
                            <p><span>类型:</span><b class="car_type">Aston-Martin</b></p>
                            <p><span>价格:</span><b class="car_price">Aston-Martin</b></p>
                            <p><span>发动机:</span>V12</p>
                            <p><span>排量:</span>5.2 L</p>
                            <p><span>0-60 加速:</span>3.9 S.</p>
                            <p><span>最高时速:</span>200 mph</p>
                        </div>
                    </aside>
                    <div class="padding-50"></div>
                </div>
            </div><!-- Row /- -->
            <div class="padding-100"></div>
        </div><!-- Container /- -->

    </main>


    <!-- Footer Section -->
    <!-- Footer Section -->
    <#include "footer.ftl">
</div>


<script src="/js/carDetail.js"></script>
</body>
</html>
