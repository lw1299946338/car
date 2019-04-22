package com.example.car.car.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.car.car.model.Car;
import com.example.car.car.service.CarService;
import com.example.car.lang.BaseResponse;
import com.example.car.util.ResultUtil;
import com.example.car.util.aop.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/car")
@Slf4j
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/list")
    @SystemLog
    public BaseResponse list(Map<String,Object> map){
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        wrapper.eq("status","1");
        return ResultUtil.success(carService.list(wrapper));
    }

    @GetMapping("/brands")
    @SystemLog(module = "car",methods = "获取汽车品牌")
    public BaseResponse brands(Map<String,Object> map){

        return ResultUtil.success(carService.brandList());
    }

    @GetMapping("/ids")
    @SystemLog(module = "ids",methods = "根据多个id获取详细信息(多个用,分隔)")
    public List<Car> ids(@RequestParam("ids")String ids){
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        wrapper.in("id",ids.split(","));
        return carService.list(wrapper);
    }
    @GetMapping("/id")
    @SystemLog(module = "id",methods = "根据单个id获取详细信息")
    public Car id(@RequestParam("id")String id){
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return carService.getOne(wrapper);
    }

}

