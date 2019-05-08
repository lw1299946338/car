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
                            <li id="userAdmin" role="presentation">
                                <a href="#coupe" role="tab" data-toggle="tab"><i><img src="/images/vt-ic4.png" alt="vt-ic"></i>用户管理</a>
                            </li>
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
                                        <th>所在城市</th>
                                        <th>状态</th>
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
                                <div class="text-right">
                                    <button id="addDriver" type="button" class="btn btn-primary">
                                        新建
                                    </button>
                                </div>
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>司机姓名</th>
                                        <th>司机电话</th>
                                        <th>所在城市</th>
                                        <th>健康状态</th>
                                        <th>状态</th>
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
                                <div class="text-right">
                                    <button id="addUser" type="button" class="btn btn-primary">
                                        新建
                                    </button>
                                </div>
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>用户姓名</th>
                                        <th>用户名</th>
                                        <th>用户密码</th>
                                        <th>支付密码</th>
                                        <th>手机号</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="userTable">
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
                    </div>
                </div>
            </div>
        </div>
        <div class="padding-30"></div>
    </main>
    <!-- addDriverModal -->
    <div class="modal fade" id="driverModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新建司机</h4>
                </div>
                <div class="modal-body">
                    <form id="addDriverForm" class="form-horizontal">
                            <input type="hidden" name="id">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="driverName" class="form-control" placeholder="请输入姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">身份证号</label>
                                <div class="col-sm-9">
                                    <input type="text" name="driverCard" class="form-control" placeholder="请输入身份证号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="driverGender">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">手机号</label>
                                <div class="col-sm-9">
                                    <input type="number" name="driverPhone" class="form-control" placeholder="请输入手机号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">年龄</label>
                                <div class="col-sm-9">
                                    <input type="number" name="driverAge" class="form-control" placeholder="请输入年龄">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">驾龄</label>
                                <div class="col-sm-9">
                                    <input type="number" name="driverYear" class="form-control" placeholder="请输入驾龄">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">驾照级别</label>
                                <div class="col-sm-9">
                                    <input type="text" name="driverLevel" class="form-control" placeholder="请输入驾照级别">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">地区</label>
                                <div class="col-sm-9">
                                    <input type="text" name="driverCity" class="form-control" placeholder="请输入地区">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">健康状况</label>
                                <div class="col-sm-9">
                                    <input type="text" name="driverHealth" class="form-control" placeholder="请输入健康状况(健康或有无疾病)">
                                </div>
                            </div>
                        </form>
                </div>
                <div class="modal-footer">
                    <button id="aDriverBtn" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="saveDriverBtn" type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- addDriverModal -->
    <div class="modal fade" id="userModel" tabindex="-1" role="dialog" aria-labelledby="userModelLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="userModalText">新建用户</h4>
                </div>
                <div class="modal-body">
                    <form id="addUserForm" class="form-horizontal">
                        <input type="hidden" name="id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户名</label>
                            <div class="col-sm-9">
                                <input type="text" name="userName" class="form-control" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">登录密码</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" class="form-control" placeholder="请输入登录密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户姓名</label>
                            <div class="col-sm-9">
                                <input type="text" name="name" class="form-control" placeholder="请输入用户姓名">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">手机号</label>
                            <div class="col-sm-9">
                                <input type="text" name="phone" class="form-control" placeholder="请输入手机号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">支付密码</label>
                            <div class="col-sm-9">
                                <input type="password" name="payPassword" class="form-control" placeholder="请输入支付密码">
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button id="aUserBtn" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="saveUserBtn" type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer Section -->
    <#include "footer.ftl"/>
    <script type="application/javascript" src="/js/admin.js"></script>
</div>



</body>
</html>
