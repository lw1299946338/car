package com.example.car.driver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.car.car.model.Car;
import com.example.car.car.service.CarService;
import com.example.car.driver.model.Driver;
import com.example.car.driver.service.DriverService;
import com.example.car.jwt.PassToken;
import com.example.car.lang.BaseResponse;
import com.example.car.util.ResultUtil;
import com.example.car.util.aop.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 司机表 前端控制器
 * </p>
 *
 * @author liwei
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/driver")
@Slf4j
public class DriverController {

    @Autowired
    CarService carService;

    @Autowired
    DriverService driverService;

    @GetMapping("/list")
    @SystemLog(module = "司机",methods = "获取司机列表")
    public BaseResponse list(Map<String,Object> map){
        QueryWrapper<Driver> wrapper = new QueryWrapper<>();
        return ResultUtil.success(driverService.list(wrapper));
    }

    @GetMapping("/update")
    @SystemLog(module = "司机",methods = "更新司机状态")
    public BaseResponse update(@RequestParam("id") Integer id,@RequestParam("status") String status){
        UpdateWrapper<Driver> wrapper = new UpdateWrapper<>();
        Driver driver = new Driver();
        driver.setId(id);
        driver.setStatus(status.equals("1")?"0":"1");
        return ResultUtil.success(driver.updateById());
    }

}

