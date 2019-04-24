package com.example.car.order.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.car.car.model.Car;
import com.example.car.car.service.CarService;
import com.example.car.jwt.JwtUtils;
import com.example.car.lang.BaseResponse;
import com.example.car.order.model.Order;
import com.example.car.order.service.OrderService;
import com.example.car.shopcart.model.ShopCart;
import com.example.car.shopcart.service.ShopCartService;
import com.example.car.util.ResultUtil;
import com.example.car.util.StringUtils;
import com.example.car.util.aop.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    CarService carService;

    @Autowired
    ShopCartService shopCartService;

    @Autowired
    OrderService orderService;

    @SystemLog
    @PostMapping("/create")
    public BaseResponse create(@RequestHeader("token") String token,@RequestParam("param") String param){

        List<String> carIds = new ArrayList<>();
        //应付金额
        BigDecimal payableNumber = BigDecimal.ZERO;
        String[] cars = param.split(",");
        //商品id:商品数量
        for (String x : cars) {
            String[] split = x.split(":");
            carIds.add(split[0]);
            Car car = carService.getById(split[0]);
            //计算商品总价
            payableNumber = payableNumber.add(car.getPrice().multiply(new BigDecimal(Integer.parseInt(split[1]))));
        }
        String userId = JwtUtils.getUserIdByToken(token);
        String orderNumber = String.valueOf(System.currentTimeMillis());
        Order order = new Order(null,userId,orderNumber,param,new Date(),"0",null,payableNumber,BigDecimal.ZERO);
        boolean insert = order.insert();
        //生成订单后,删除购物车数据
        if (insert){
            QueryWrapper<ShopCart> a = new QueryWrapper<>();
            a.eq("user_id",userId);
            a.in("car_id",carIds);
            shopCartService.remove(a);
        }
        return ResultUtil.success(insert);
    }

    @SystemLog
    @PostMapping("/list")
    public BaseResponse list(@RequestHeader("token") String token,Map<String,String> map){
        String payStatus = map.get("payStatus");
        String id = JwtUtils.getUserIdByToken(token);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        if (StringUtils.isNotBlank(payStatus)){
            wrapper.eq("pay_status",payStatus);
        }
        List<Order> orderList = orderService.list(wrapper);
        return ResultUtil.success(orderList);
    }

    @SystemLog
    @PostMapping("/orderNumber")
    public BaseResponse id(@RequestHeader("orderNumber") String token,@RequestParam("id") String orderNumber){
        String userId = JwtUtils.getUserIdByToken(token);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("order_number",orderNumber);
        return ResultUtil.success(orderService.getOne(wrapper));
    }

}

