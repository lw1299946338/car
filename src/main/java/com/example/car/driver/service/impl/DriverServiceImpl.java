package com.example.car.driver.service.impl;

import com.example.car.driver.model.Driver;
import com.example.car.driver.mapper.DriverMapper;
import com.example.car.driver.service.DriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 司机表 服务实现类
 * </p>
 *
 * @author liwei
 * @since 2019-04-27
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements DriverService {

}
