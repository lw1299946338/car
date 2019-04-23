package com.example.car.shopcart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.car.car.model.Car;
import com.example.car.car.service.CarService;
import com.example.car.jwt.JwtUtils;
import com.example.car.jwt.PassToken;
import com.example.car.lang.BaseResponse;
import com.example.car.shopcart.model.ShopCart;
import com.example.car.shopcart.service.ShopCartService;
import com.example.car.util.ResultUtil;
import com.example.car.util.StringUtils;
import com.example.car.util.aop.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    @Autowired
    CarService carService;


    @PostMapping("/add")
    @SystemLog
    public BaseResponse add(@RequestHeader("token") String token, @RequestParam("carId") String carId){
        String userId = JwtUtils.getUserIdByToken(token);
        QueryWrapper<ShopCart> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("car_id",carId);
        ShopCart shopCart = shopCartService.getOne(wrapper);
        if (shopCart == null){
            shopCart = new ShopCart(StringUtils.getUUID(),userId,Integer.parseInt(carId),1,new Date());
        }else{
            shopCart.countAdd();
        }
        if (shopCart.insertOrUpdate()){
            return ResultUtil.success();
        }else{
            return ResultUtil.error("201","添加失败");
        }

    }

    @PostMapping("/list")
    @SystemLog
    public BaseResponse list(@RequestHeader("token") String token){
        String userId = JwtUtils.getUserIdByToken(token);
        QueryWrapper<ShopCart> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<ShopCart> list = shopCartService.list(wrapper);
        List<Car> list1 = new ArrayList<>();
        for (ShopCart shopCart : list) {
            QueryWrapper<Car> carQueryWrapper = new QueryWrapper<>();
            carQueryWrapper.eq("id",shopCart.getCarId());
            Car car = carService.getOne(carQueryWrapper);
            car.setCount(shopCart.getCarCount());
            list1.add(car);
        }
        return ResultUtil.success(list1);

    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestHeader("token") String token,@RequestParam("carId")String carId) {
        String userId = JwtUtils.getUserIdByToken(token);
        QueryWrapper<ShopCart> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("car_id",carId);
        boolean remove = shopCartService.remove(wrapper);
        return ResultUtil.success(remove);
    }

    @PostMapping("/redu")
    public BaseResponse redu(@RequestHeader("token") String token,@RequestParam("carId")String carId) {
        String userId = JwtUtils.getUserIdByToken(token);
        QueryWrapper<ShopCart> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("car_id",carId);
        ShopCart one = shopCartService.getOne(wrapper);
        one.countRemove();
        return ResultUtil.success(one.insertOrUpdate());
    }



}

