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
        <!-- Contact Section -->
        <div class="container-fluid no-padding contact-section">
            <!-- Container -->
            <div class="container">
                <!-- Section Header -->
                <div class="section-header">
                    <h3>后台管理中心</h3>
                    <p>It is a beautiful day in this neighborhood a beautiful day for a neighbor would you be mine could you be mine its a neighborly day in this beautywood.</p>
                </div><!-- Section Header /- -->
                <div class="row">
                    <div class="col-md-2 col-sm-2 col-xs-12 vehicaltype-tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a id="carAdmin" href="#suv" role="tab" data-toggle="tab"><i><img src="/images/vt-ic1.png" alt="vt-ic"></i>车辆管理</a>
                            </li>
                            <li id="orderAdmin" role="presentation">
                                <a href="#pickup" role="tab" data-toggle="tab"><i><img src="/images/vt-ic2.png" alt="vt-ic"></i>订单管理</a>
                            </li>
                            <li id="driverAdmin" role="presentation">
                                <a href="#convertible" role="tab" data-toggle="tab"><i><img src="/images/vt-ic3.png" alt="vt-ic"></i>司机管理</a>
                            </li>
                            <#--<li role="presentation">-->
                                <#--<a href="#sedan" role="tab" data-toggle="tab"><i><img src="/images/vt-ic4.png" alt="vt-ic"></i>sedan</a>-->
                            <#--</li>-->
                            <#--<li role="presentation">-->
                                <#--<a href="#coupe" role="tab" data-toggle="tab"><i><img src="/images/vt-ic5.png" alt="vt-ic"></i>coupe</a>-->
                            <#--</li>-->
                        </ul>
                    </div>
                    <!-- Tab panes -->
                    <div class="tab-content col-md-10 col-sm-10 col-xs-12 vehicaltype-content">
                        <div role="tabpanel" class="tab-pane active" id="suv">
                            <div id="carousel-suv" class="carousel slide" data-ride="carousel">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>汽车品牌</th>
                                        <th>汽车名称</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="carTable">
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="pickup">
                            <div id="carousel-pickup" class="carousel slide" data-ride="carousel">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>订单号</th>
                                        <th>订单金额</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="orderTable">
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="convertible">
                            <div id="carousel-convertible" class="carousel slide" data-ride="carousel">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>司机姓名</th>
                                        <th>司机电话</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="driverTable">
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="sedan">
                            <div id="carousel-sedan" class="carousel slide" data-ride="carousel">
                                sedan
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="coupe">
                            <div id="carousel-coupe" class="carousel slide" data-ride="carousel">
                                coupe
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="padding-30"></div>
    </main>


    <!-- Footer Section -->
    <#include "footer.ftl"/>
    <script type="application/javascript" src="/js/admin.js"></script>
</div>



</body>
</html>
