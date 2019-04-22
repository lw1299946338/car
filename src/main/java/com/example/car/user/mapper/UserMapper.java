package com.example.car.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.car.user.model.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liwei
 * @since 2019-02-27
 */
public interface UserMapper extends BaseMapper<User> {
    public List<Object> carList();
}
