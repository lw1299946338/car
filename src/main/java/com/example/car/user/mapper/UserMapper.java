package com.example.car.user.mapper;

import com.example.car.user.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select is_admin from t_user where id=#{id}")
    String isAdmin(@Param("id") String id);
}
