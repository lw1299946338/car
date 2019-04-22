package com.example.car.util;

import java.math.BigDecimal;

/**
 * @author shipan
 * @Description: TODO  两个数的 加减乘除运算
 * @ClassName: com.loan.stages.util
 * @date 2019/4/4 13:55
 */
public class AmountOperate {

    /**
     * @Description TODO  加法运算
     * @date 2019/4/4
     * @param str1, str2
     * @return java.lang.String
     * @author shipan
     */
    public static String add(String str1,String str2){
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        BigDecimal add = bigDecimal1.add(bigDecimal2);
        return add.toString();
    }

    /**
     * @Description TODO  减法运算 str1-str2
     * @date 2019/4/4
     * @param str1, str2
     * @return java.lang.String
     * @author shipan
     */
    public static String sub(String str1,String str2){
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal2);
        return subtract.toString();
    }
    /**
     * @Description TODO 乘法运算
     * @date 2019/4/4
     * @param str1, str2
     * @return java.lang.String
     * @author shipan
     */
    public static String multiply(String str1,String str2){
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);
        return multiply.toString();
    }

    /**
     * @Description TODO 除法运算 str1/str2
     * @date 2019/4/4
     * @param str1, str2
     * @return java.lang.String
     * @author shipan
     */
    public static String divide(String str1,String str2){
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        BigDecimal divide = bigDecimal1.divide(bigDecimal2);
        return divide.toString();
    }

}
