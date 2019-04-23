package com.example.car.car.service.impl;

import com.example.car.car.model.Car;
import com.example.car.car.mapper.CarMapper;
import com.example.car.car.service.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
@Service("carService")
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
    @Override
    public List<String> brandList() {
        return baseMapper.brandList();
    }
}
