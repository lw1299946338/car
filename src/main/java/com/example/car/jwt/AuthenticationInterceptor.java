package com.example.car.jwt;

import com.example.car.enums.ResErrMessageEnum;
import com.example.car.expection.BaseException;
import com.example.car.redis.RedisCacheUtil;
import com.example.car.redis.RedisKeyPrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author liwei
 * @date 2019/3/6 10:12 AM
 */
@Component("authenticationInterceptor")
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    RedisCacheUtil<?> cacheUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        //log.info("请求地址:{},token={}",request.getRequestURL().toString(),token);
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        log.info("请求地址:{},token={}",request.getRequestURL().toString(),token);
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (token == null) {
            throw new BaseException(ResErrMessageEnum.InvalidToken);
        }
//        // 获取 token 中的 user id
//        String userId;
//        try {
//            userId = JWT.decode(token).getAudience().get(0);
//        } catch (JWTDecodeException j) {
//            throw new BaseException("401","用户不存在，请重新登录");
//        }

        boolean exists = cacheUtil.exists(token);
        if (!exists){
            throw new BaseException("400","用户不存在，请重新登录");
        }
        return exists;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
