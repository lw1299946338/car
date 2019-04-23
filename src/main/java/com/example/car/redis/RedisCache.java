package com.example.car.redis;

/**
 * @program stages
 * @description:
 * @author: liwei
 * @create: 2019/2/28 10:24 AM
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis缓存注解定义
 * @author liwei
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisCache {
    /**数据类型*/
    public String dataType() default "";

    /**
     * 缓存key
     * 默认取方法包路径
     */
    public String key() default "";

    /**
     * 有效时间 - 默认5分钟
     * 单位秒
     */
    public int expire() default 5*60;		//缓存多少秒,默认5分钟

    public boolean type() default false;

}

