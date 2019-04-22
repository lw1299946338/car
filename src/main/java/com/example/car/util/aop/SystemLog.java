package com.example.car.util.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//目标是方法
@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Documented//文档生成时，该注解将被包含在javadoc中，可去掉
public @interface SystemLog {

    /**
     * 模块名
     * @return
     */
    String module() default "";

    /**
     * 方法名
     * @return
     */
    String methods() default "";

}
