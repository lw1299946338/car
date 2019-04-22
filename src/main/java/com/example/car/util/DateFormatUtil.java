package com.example.car.util;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author shipan
 * @Description: TODO  生成唯一id 工具类
 * @ClassName: com.loan.stages.util
 * @date 2019/4/8 11:23
 */
public class DateFormatUtil {

    private static String patterndate1 = "yyyy-MM-dd";

    private static String patterndate2 = "yyyy/MM/dd";

    private static String pattern1 = "yyyyMMddHHmmss";

    private static String pattern2 = "yyyy-MM-dd HH:mm:ss";

    /***
     * @Description TODO 根据给定的格式生成时间
     * @date 2019/4/8
     * @param
     * @return java.lang.String
     * @author shipan
     */
    public static String dateTimeBypattern(String pattern){
        LocalDateTime localDateTime = LocalDateTime.now(Clock.system(ZoneId.of("+8")));
        String format = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        return format;
    }

    /***
     * @Description TODO 获取时间戳
     * @date 2019/4/8
     * @param
     * @return java.lang.String
     * @author shipan
     */
    public static String timestamp(){
        LocalDateTime now = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));
        long l = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String s = String.valueOf(l);
        return s;
    }

}
