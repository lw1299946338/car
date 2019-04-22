package com.example.car.util;

/**
 * @author shipan
 * @Description: 正则表达式校验工具类
 * @ClassName: com.loan.stages.util
 * @date 2019/3/14 10:28
 */
public class RegexpValidateUtils {

    /**
     * @Description TODO
     * @date 2019/3/14
     * @param regex：正则表达式 , str：需要校验的字符串
     * @return java.lang.Boolean
     * @author shipan
     */
    public static Boolean match(String regex,String str){
        //Pattern pattern = Pattern.compile(regex);
        boolean matches = str.matches(regex);
        return matches;
    }
    /**
     * @Description TODO 校验银行卡号是否正确 1、必须大于15位  必须全是数字
     * @date 2019/3/14
     * @param str 银行卡号
     * @return java.lang.Boolean
     * @author shipan
     */
    public static Boolean iscardNo(String str){
        String regex = "([1-9]\\d{15,})$";
        Boolean result = false;
        if(null != str){
            result = match(regex,str);
        }
        return result;
    }

    public static void main(String[] args) {
        String card = "7217850299876754";
        String regex = "([1-9]\\d{15,})$";
        Boolean match = match(regex, card);
        System.out.println(match);
    }


}
