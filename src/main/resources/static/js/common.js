
var page=["index","shopCar","user","admin","registory"];
$(function () {
    if (localStorage.getItem("token") !=null){
        var h = "<li id='user' class=\"dropdown\"><a href=\"/p/user\" title=\"用户中心\">用户中心</a></li>";
        h += "<li id='loginOut' class=\"dropdown\"><a href='javascript:method.loginOut()' title=\"退出登录\">退出登录</a></li>";
        $("#user1").append(h);
    }else{
        var h = "<li id='user' class=\"dropdown\"><a href=\"/p/login\" title=\"登录\">登录</a></li>";
        h += "<li id='registory' class=\"dropdown\"><a href=\"/p/registory\" title=\"注册\">注册</a></li>";
        $("#user1").append(h);
    }

    if (method.isAdmin()){
        var h = "<li id='admin' class=\"dropdown\"><a href=\"/p/admin\" title=\"后台管理\">后台管理</a></li>";
        $("#user1").append(h);
    }
    page.forEach(function (value) {
        if (window.location.href.indexOf(value) != -1){
            $("#"+value).addClass("active");
        }
    })

    $("#site-loader").delay(1000).fadeOut("slow");
});

var shopCar = {
    KEY:"shopCar",
    add:function (id) {
        method.ajax({
            type:"POST",
            url:"/shopCart/add",
            data:{"carId":id},
            success:function (data) {
                if (data.errCode=="200") {
                    method.alertSuccess("添加成功","");
                    // var list = shopCar.getIdList();
                    // // 2.0 将obj 追加到list中
                    // list.push(id);
                    // // 3.0 将list数据转出json字符串存储到localStorage中
                    // localStorage.setItem(shopCar.KEY,JSON.stringify(list))
                    // alert("购物车已有"+list.length+"个:"+list)
                }else if (data.errCode=="202") {
                    method.alertCheck(data.errMsg,"",function () {
                        window.location.href="/p/shopCar";
                    })
                }else{
                    method.alertError("添加失敗","");
                }

            }
        });

    },
    getIdList:function () {
        var lsSting = localStorage.getItem(shopCar.KEY);
        var list = [];
        if(lsSting){
            list = JSON.parse(lsSting);
        }
        return list;
    },
    getCars:function () {
        // application/json
        var list = new Array();
        method.ajax({
            url:"/shopCart/list",
            //data:{"ids":shopCar.idString()},
            type : "post",
            async : false,
            contentType: "application/x-www-form-urlencoded",
            success : function (data) {
                console.log(data);
                if (data.errCode == "200"){
                    list = data.data;
                }
            }
        })
        return list;
    },
    //删除
    remove:function (id) {
        console.log("删除id:"+id)
        method.ajax({
            url:"/shopCart/delete",
            data:{"carId":id},
            type:"post",
            success:function (data) {
                if (data.errCode=="200" && data.data){
                    method.alertSuccess("删除成功","");
                } else {
                    alert("删除失败");
                }
            }
        })
    },
    //减天数
    redu:function (id) {
        method.ajax({
            type:"POST",
            url:"/shopCart/redu",
            data:{"carId":id},
            success:function (data) {
                if (data.errCode=="200" && data.data){
                    method.alertSuccess("操作成功","");
                } else {
                    alert("删除失败");
                }
            }
        });
    },
    //加天数
    redc:function (id) {
        method.ajax({
            type:"POST",
            url:"/shopCart/redc",
            data:{"carId":id},
            success:function (data) {
                if (data.errCode=="200"){
                    method.alertSuccess("操作成功","");
                } else {
                    alert("操作失败");
                }
            }
        });
    }
}
var method = {

    loginOut:function(){
        if (method.getToken()!=null){
            method.ajax({
                url:"/user/loginOut",
                type:"get",
                success:function (data) {
                    ;
                }
            })
        }
        localStorage.clear();
        window.location.href="/p/index";
    },
    getToken:function(){
      return localStorage.getItem("token") ;
    },
    isAdmin:function(){
        var x = false;
        if (null!=localStorage.getItem("user")){
            var item = localStorage.getItem("user");
            x = JSON.parse(item).isAdmin=="1"?true:false;
        }
        return x;
    },

    // 获取url参数
    getUrlParams: function(name) {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
            return  r[2];
        else
            return "";
    },
    ajax:function (settings) {
        var that = this;
        var defPar = {
            type: 'get',
            url: '',
            dataType: 'json',
            data: {},
            async: false,
            cache: false,
            contentType: "application/x-www-form-urlencoded",
            //contentType: "application/json",
            success: function(res) {
            },
            error: function(res) {}
        };
        $.extend(defPar, settings);
        $.ajax({
            headers: {"token":localStorage.getItem("token")},
            type: defPar.type,
            url: defPar.url,
            // dataType: defPar.dataType,
            data: defPar.data,
            async: defPar.async,
            cache: defPar.cache,
            contentType: defPar.contentType,
            success: function (res) {
                if (res.errCode=="400"){
                    localStorage.setItem("oldPage",window.location.href);
                    window.location.href="/p/login";
                    return;
                }else if (res.errCode == "500"){
                    alert(res.errMsg);
                } else{
                    defPar.success(res);
                }

            },
            error: function (res) {
            }
        });
    },
    getCarById:function (id) {
        var car = {};
        method.ajax({
            url:"/car/id",
            type:"get",
            async: false,
            data:{"id":id},
            success:function (data) {
                car = data;
            }
        });
        return car;
    },
    alertSuccess:function(title,text){

        swal(title, text, "success");
    },
    alertCheck:function (title,text,e) {
        swal({
            title: title,
            text: text,
            icon: "warning",
            buttons: ["取消",true],
            dangerMode: true,
        }).then((willDelete) => {
                if (willDelete) {
                    //ok
                    e();
                    //e.call(this);
                }
            });
    },
    alertError:function (title,text) {
        swal(title, text, "error");
    },
    Object : {
        notNull : function(a) {
            if (a === null) return false;
            else if (a === undefined) return false;
            else if (a === "undefined") return false;
            else if (a === "") return false;
            else if (a === "[]") return false;
            else if (a === "{}") return false;
            else return true
        },
        notEmpty : function(a) {
            if (a === null) return "";
            else if (a === undefined) return "";
            else if (a === "undefined") return "";
            else if (a === "") return "";
            else if (a === "[]") return "";
            else if (a === "{}") return "";
            else return a
        },
        serialize : function(b) {
            var o = {};
            $.each(b.serializeArray(), function(a) {
                if (o[this['name']]) {
                    o[this['name']] = o[this['name']] + "," + this['value']
                } else {
                    o[this['name']] = this['value']
                }
            });
            return o
        },
        comVar : function(a) {
            var b = "",
                values = "",
                types = "",
                vars = {};
            if (a) {
                $.each(a, function() {
                    if (b != "") {
                        b += ",";
                        values += ",";
                        types += ","
                    }
                    b += this.key;
                    values += this.value;
                    types += this.type
                })
            }
            vars = {
                keys : b,
                values : values,
                types : types
            };
            return vars
        }

    },
}


