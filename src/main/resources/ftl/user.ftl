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
        <div class="container-fluid no-padding contact-section">
            <!-- Container -->
            <div class="container">
                <!-- Section Header -->
                <div class="section-header">
                    <h3>用户中心</h3>
                    <p>It is a beautiful day in this neighborhood a beautiful day for a neighbor would you be mine could you be mine its a neighborly day in this beautywood.</p>
                </div><!-- Section Header /- -->
                <div class="row">
                    <div class="col-md-2 col-sm-2 col-xs-12 vehicaltype-tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" >
                                <a id="userDetail" href="#suv" role="tab" data-toggle="tab"><i><img src="/images/vt-ic1.png" alt="vt-ic"></i>用户信息</a>
                            </li>
                            <li id="userOrder" class="active" role="presentation">
                                <a href="#pickup" role="tab" data-toggle="tab"><i><img src="/images/vt-ic2.png" alt="vt-ic"></i>订单管理</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Tab panes -->
                    <div class="tab-content col-md-10 col-sm-10 col-xs-12 vehicaltype-content">
                        <div role="tabpanel" class="tab-pane " id="suv">
                            <div id="carousel-suv" class="carousel slide" data-ride="carousel">

                                <div class="col-md-4 col-sm-4 col-xs-12 widget-area">
                                    <aside class="widget widget_specifiaction">
                                        <h3 class="widget-title">UserDetail</h3>
                                        <div id="user" class="specifications-content">
                                            <p><span>账号:</span><b class="name"></b></p>
                                            <p><span>用户姓名:</span><b class="user_name"></b></p>
                                            <p><span>手机号:</span><b class="phone"></b></p>
                                            <p><span>支付密码:</span><b class="paypassword"></b></p>
                                        </div>
                                    </aside>
                                    <div class="padding-50"></div>
                                </div>


                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane active" id="pickup">
                            <div id="carousel-pickup" class="carousel slide" data-ride="carousel">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>订单号</th>
                                        <th>订单金额</th>
                                        <th>订单状态</th>
                                        <th>实际支付金额</th>
                                        <th>支付时间</th>
                                        <th>创建时间</th>
                                        <th>预计还车时间</th>
                                        <th>实际还车时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="orderTable">

                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="padding-30"></div>
    </main>

    <div id="payModel" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">支付订单</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">支付密码</label>
                        <div class="col-sm-9">
                            <input id="pay_password" type="password" name="driverAge" class="form-control" placeholder="请输入支付密码">
                        </div>
                    </div>
                </div>
                <div class="padding-20"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" onclick="user.pay()" class="btn btn-primary">支付</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!-- Footer Section -->
    <#include "footer.ftl"/>
    <script type="application/javascript" src="/js/user.js"></script>
</div>
</body>
</html>
