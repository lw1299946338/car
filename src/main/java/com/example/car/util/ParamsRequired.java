package com.example.car.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yyj
 * Date  2019/2/25.
 */


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamsRequired {
    /**
     * 必须参数
     * @return
     */
    boolean requrie() default true;

}
