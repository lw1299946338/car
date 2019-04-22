package com.example.car.car.service;

import com.example.car.car.model.Car;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
public interface CarService extends IService<Car> {

    List<String> brandList();
}
