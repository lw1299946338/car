package com.example.car.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.car.enums.ResErrMessageEnum;
import com.example.car.jwt.AuthenticationInterceptor;
import com.example.car.jwt.JwtUtils;
import com.example.car.lang.BaseResponse;
import com.example.car.redis.RedisCacheUtil;
import com.example.car.user.model.User;
import com.example.car.user.service.UserService;
import com.example.car.util.ResultUtil;
import com.example.car.util.StringUtils;
import com.example.car.util.aop.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liwei
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisCacheUtil<?> redisCacheUtil;

    @PostMapping("/login")
    @SystemLog
    public BaseResponse login(User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName());
        User one = userService.getOne(wrapper);
        if (StringUtils.isBlank(one)){
            return ResultUtil.error(ResErrMessageEnum.EmptyUser);
        }
        if (!one.getPassword().equals(user.getPassword())){
            return ResultUtil.error(ResErrMessageEnum.InvalidPassword);
        }
        String token = JwtUtils.getToken(one.getId());
        AuthenticationInterceptor.cacheMap.put(token,one.getId());
        //redisCacheUtil.setCacheObject(token,one);
        return ResultUtil.success(token);

    }

}

