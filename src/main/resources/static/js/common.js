
var shopCar = {
    KEY:"shopCar",
    add:function (id) {
        var list = shopCar.getIdList();
        // 2.0 将obj 追加到list中
        list.push(id);
        // 3.0 将list数据转出json字符串存储到localStorage中
        localStorage.setItem(shopCar.KEY,JSON.stringify(list))
        alert("购物车已有"+list.length+"个:"+list)
    },
    getIdList:function () {
        var lsSting = localStorage.getItem(shopCar.KEY);
        var list = [];
        if(lsSting){
            list = JSON.parse(lsSting);
        }
        return list;
    },
    count:function () {
        var list = shopCar.getIdList();
        // 2.0 计算总数
        var totalcount = 0;
        list.forEach(function(item){
            totalcount+=item.count;
        })
        return totalcount;
    },
    idString:function () {
        var obj = shopCar.getIdList();
        return obj.join(',');
    },
    getCars:function () {
        var list = new Array();
        $.ajax({
            url:"/car/ids",
            data:{"ids":shopCar.idString()},
            type : "get",
            async : false,
            contentType: "application/json",
            success : function (data) {
                console.log(data);
                list = data;
            }
        })
        return list;
    },
    remove:function (id) {
        console.log("删除id:"+id)
        // 获取数据
        var list = shopCar.getIdList();
        var newList=[];
        // 删除list中对应的goodsid的数据
        var conut = 0;
        for(let item in list){
            if(list[item] != id){
                newList.push(list[item]);
            }else{
                conut++;
            }
        }
        // 写入新数据
        // 3.0 将list数据转出json字符串存储到localStorage中
        localStorage.setItem(shopCar.KEY,JSON.stringify(newList))
        return conut;
    }
}
var method = {
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
            contentType: "application/json",
            success: function(res) {
            },
            error: function(res) {}
        };
        $.extend(defPar, settings);
        $.ajax({
            headers: settings.headers,
            type: defPar.type,
            url: defPar.url,
            // dataType: defPar.dataType,
            data: defPar.data,
            async: defPar.async,
            cache: defPar.cache,
            contentType: defPar.contentType,
            beforeSend: function () {
                if (defPar.loading) {
                    that.loadingStart();
                }
            },
            success: function (res) {
                defPar.success(res);
            },
            error: function (res) {
                that.toast('服务器请求失败');
                defPar.error(res)
            }
        });
    }
}


