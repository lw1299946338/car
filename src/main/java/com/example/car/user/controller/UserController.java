package com.example.car.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.car.enums.ResErrMessageEnum;
import com.example.car.jwt.AuthenticationInterceptor;
import com.example.car.jwt.JwtUtils;
import com.example.car.jwt.PassToken;
import com.example.car.lang.BaseResponse;
import com.example.car.redis.RedisCacheUtil;
import com.example.car.user.model.User;
import com.example.car.user.service.UserService;
import com.example.car.util.ResultUtil;
import com.example.car.util.StringUtils;
import com.example.car.util.aop.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResultUtil.error("200",token,one);

    }

    @PostMapping("/registory")
    @SystemLog(module = "用户",methods = "注册用户")
    @PassToken
    public BaseResponse registory(User user){
        user.setIsAdmin("0");
        user.insert();
        String token = JwtUtils.getToken(user.getId());
        AuthenticationInterceptor.cacheMap.put(token,user.getId());
        //redisCacheUtil.setCacheObject(token,one);
        return ResultUtil.error("200",token,user);

    }

    @GetMapping("/all")
    @SystemLog
    public BaseResponse all(@RequestHeader(value = "token",required = false)String token){
        return ResultUtil.success(userService.list());
    }

    @GetMapping("/update")
    @SystemLog(module = "用户",methods = "添加用户")
    public BaseResponse add(User user){
        return ResultUtil.success(user.insertOrUpdate());
    }

    @GetMapping("/isAdmin")
    @SystemLog
    @PassToken
    public BaseResponse isAdmin(@RequestHeader(value = "token",required = false)String token){
        if (StringUtils.isBlank(token)){
            return ResultUtil.success(false);
        }
        String idByToken = JwtUtils.getUserIdByToken(token);
        String isAdmin = userService.isAdmin(idByToken);
        return ResultUtil.success("1".equals(isAdmin)?true:false);
    }

    @GetMapping("/loginOut")
    @SystemLog
    @PassToken
    public BaseResponse loginOut(@RequestHeader(value = "token")String token){
        AuthenticationInterceptor.cacheMap.remove(token);
        return ResultUtil.success(true);
    }

}

