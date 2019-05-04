$(function () {
    carDetail.init();

    $("#addCar").click(function () {
        var id = method.getUrlParams("id");
        shopCar.add(id);
    });

    /* - Inventory Carousel */
    if($("#imageGallery").length){
        $('#imageGallery').lightSlider({
            gallery:true,
            item: 1,
            thumbItem: 4,
            responsive : [
                {
                    breakpoint:992,
                    settings: {
                        thumbItem: 4
                    }
                },{
                    breakpoint:991,
                    settings: {
                        thumbItem: 3
                    }
                },{
                    breakpoint:767,
                    settings: {
                        thumbItem: 4
                    }
                },{
                    breakpoint:560,
                    settings: {
                        thumbItem: 3
                    }
                },{
                    breakpoint:400,
                    settings: {
                        thumbItem: 2
                    }
                }
            ],
            slideMargin: 0,
            thumbMargin: 10,
            speed: 500,
            auto: false,
            loop: true,
            onSliderLoad: function() {
                $('#image-gallery').removeClass('cS-hidden');
            }
        });
    }
});
var carDetail = {
    init:function () {
        var id = method.getUrlParams("id");
        console.log(id);
        method.ajax({
            url:"/car/id",
            data:{"id":id},
            success:function (data) {
                console.log(data);
                $("#imageGallery").find("li").prop("data-thumb",data.carImage);
                $("#imageGallery").find("li").find("img").prop("src",data.carImage);
                $(".car_price").text(data.price+"元/天");
                $(".car_name").text(data.carName);
                $(".car_type").text(data.carType);
                $(".car_reldate").text(data.carReldate);
                $(".car_number").text(data.carNumber);
                $(".car_brand").text(data.carBrand);
                $(".car_city").text(data.city);
                $(".car_leval").text(data.carLeval);
            }
        })
    }
}