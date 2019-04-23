package com.example.car.order.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.car.car.model.Car;
import com.example.car.car.service.CarService;
import com.example.car.jwt.JwtUtils;
import com.example.car.lang.BaseResponse;
import com.example.car.order.model.Order;
import com.example.car.util.ResultUtil;
import com.example.car.util.aop.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CarService carService;

    @PostMapping("/create")
    @SystemLog
    public BaseResponse create(@RequestHeader("token") String token,@RequestParam("param") String param){
        //应付金额
        BigDecimal payableNumber = new BigDecimal(10);
        String[] cars = param.split(",");
        //商品id:商品数量
        for (String x : cars) {
            String[] split = x.split(":");
            Car car = carService.getById(split[0]);
            //计算商品总价
            payableNumber.add(car.getPrice().multiply(new BigDecimal(Integer.parseInt(split[1]))));
        }
        String userId = JwtUtils.getUserIdByToken(token);
        String orderNumber = String.valueOf(System.currentTimeMillis());
        Order order = new Order(null,userId,orderNumber,param,new Date(),"0",null,payableNumber,null);
        return ResultUtil.success(order.insert());
    }

}

