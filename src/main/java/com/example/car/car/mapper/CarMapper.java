package com.example.car.car.mapper;

import com.example.car.car.model.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liwei
 * @since 2019-04-22
 */
public interface CarMapper extends BaseMapper<Car> {

    @Select("select car_brand from car group by car_brand")
    List<String> brandList();
}
