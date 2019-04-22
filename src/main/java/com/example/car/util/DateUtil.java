package com.example.car.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DateUtil {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DateUtil.class);

    public static String getFormatedCurDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = Calendar.getInstance().getTime();
        return sdf.format(d);
    }

    public static Date strToDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("时间转换错误",e);
        }
        return d;
    }

    public static int getIntervalMinutes(Date start, Date end) {
        if (start.after(end)) {
            Date cal = start;
            start = end;
            end = cal;
        }
        long sl = start.getTime();
        long el = end.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60));
    }

    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss:sss";

    /**
     * 功能: 将日期对象按照某种格式进行转换，返回转换后的字符串
     *
     * @param date
     *            日期对象
     * @param pattern
     *            转换格式 例：yyyy-MM-dd
     */
    public static String DateToString(Date date, String pattern) {
        String strDateTime = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        strDateTime = date == null ? null : formater.format(date);
        return strDateTime;
    }

    /**
     * 功能: 将传入的日期对象按照yyyy-MM-dd格式转换成字符串返回
     *
     * @param date
     *            日期对象
     * @return String
     */
    public static String DateToString(Date date) {
        String _pattern = "yyyy-MM-dd";
        return date == null ? null : DateToString(date, _pattern);
    }

    /**
     * 功能: 将传入的日期对象按照yyyy-MM-dd HH:mm:ss格式转换成字符串返回
     *
     * @param date
     *            日期对象
     * @return String
     */
    public static String DateTimeToString(Date date) {
        String _pattern = "yyyy-MM-dd HH:mm:ss";
        return date == null ? null : DateToString(date, _pattern);
    }

    /**
     * 功能: 将插入的字符串按格式转换成对应的日期对象
     *
     * @param str
     *            字符串
     * @param pattern
     *            格式
     * @return Date
     */
    public static Date StringToDate(String str, String pattern) {
        Date dateTime = null;
        try {
            if (str != null && !str.equals("")) {
                SimpleDateFormat formater = new SimpleDateFormat(pattern);
                dateTime = formater.parse(str);
            }
        } catch (Exception ex) {
        }
        return dateTime;
    }

    /**
     * 功能: 将传入的字符串按yyyy-MM-dd格式转换成对应的日期对象
     *
     * @param str
     *            需要转换的字符串
     * @return Date 返回值
     */
    public static Date StringToDate(String str) {
        String _pattern = "yyyy-MM-dd";
        return StringToDate(str, _pattern);
    }

    /**
     * 功能: 将传入的字符串按yyyy-MM-dd HH:mm:ss格式转换成对应的日期对象
     *
     * @param str
     *            需要转换的字符串
     * @return Date
     */
    public static Date StringToDateTime(String str) {
        String _pattern = "yyyy-MM-dd HH:mm:ss";
        return StringToDate(str, _pattern);
    }

    /**
     * 功能: 将传入的字符串转换成对应的Timestamp对象
     *
     * @param str
     *            待转换的字符串
     * @return Timestamp 转换之后的对象
     * @throws Exception
     *             Timestamp
     */
    public static Timestamp StringToDateHMS(String str) throws Throwable {
        Timestamp time = null;
        time = Timestamp.valueOf(str);
        return time;
    }

    /**
     * 功能: 根据传入的年月日返回相应的日期对象
     *
     * @param year
     *            年份
     * @param month
     *            月份
     * @param day
     *            天
     * @return Date 日期对象
     */
    public static Date YmdToDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    /**
     * 功能: 将日期对象按照MM/dd HH:mm:ss的格式进行转换，返回转换后的字符串
     *
     * @param date
     *            日期对象
     * @return String 返回值
     */
    public static String communityDateToString(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd HH:mm:ss");
        String strDateTime = date == null ? null : formater.format(date);
        return strDateTime;
    }

    public static Date getMaxDateOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, calendar.getActualMaximum(11));
            calendar.set(12, calendar.getActualMaximum(12));
            calendar.set(13, calendar.getActualMaximum(13));
            calendar.set(14, calendar.getActualMaximum(14));
            return calendar.getTime();
        }
    }

    public static Date getMinDateOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, calendar.getActualMinimum(11));
            calendar.set(12, calendar.getActualMinimum(12));
            calendar.set(13, calendar.getActualMinimum(13));
            calendar.set(14, calendar.getActualMinimum(14));
            return calendar.getTime();
        }
    }

    /**
     * 功能：返回传入日期对象（date）之后afterDays天数的日期对象
     *
     * @param date
     *            日期对象
     * @param afterDays
     *            往后天数
     * @return java.util.Date 返回值
     */
    public static Date getAfterDay(Date date, int afterDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, afterDays);
        return cal.getTime();
    }
    /**
     * 功能：返回传入日期对象（date）之后afterDays天数的日期对象
     *
     * @param date
     *            日期对象
     * @param afterDays
     *            往后天数
     * @return String 返回值
     */
    public static String getAfterDayRStr(Date date, int afterDays) {
        Date afterDay = DateUtil.getAfterDay(date, afterDays);
        return DateUtil.DateToString(afterDay);
    }



    // day
    /**
     * 功能: 返回date1与date2相差的天数
     *
     * @param date1
     * @param date2
     * @return int
     */
    public static int DateDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
        return i;
    }

    // min
    /**
     * 功能: 返回date1与date2相差的分钟数
     *
     * @param date1
     * @param date2
     * @return int
     */
    public static int MinDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 1000 / 60);
        return i;
    }

    // second
    /**
     * 功能: 返回date1与date2相差的秒数
     *
     * @param date1
     * @param date2
     * @return int
     */
    public static int TimeDiff(Date date1, Date date2) {
        int i = (int) ((date1.getTime() - date2.getTime()) / 1000);
        return i;
    }

    /**
     * 功能: 返回date1与date2相差的毫秒数,(date1大于date2)
     *
     * @param date1
     * @param date2
     * @return int
     */
    public static int TimeMillisecond(String date1, String date2) {
        Date dateA = StringToDate(date1, YMDHMS);
        Date dateB = StringToDate(date2, YMDHMS);
        int i = (int) ((dateA.getTime() - dateB.getTime()));
        return i;
    }

    /**
     * @Description: 获取当前时间前几分
     * @Param
     * @Return String
     * @Author:youhuiran
     * @Datetime 2017年3月1日 下午6:35:49
     */
    public static String getBeforeTime(int n){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c=Calendar.getInstance();
        //System.out.println(sdf.format(c.getTime()));
        //c.add(Calendar.HOUR_OF_DAY, -n);//N小时前
        //System.out.println(sdf.format(c.getTime()));
        c=Calendar.getInstance();
        c.add(Calendar.MINUTE, -n);//N分钟前
        //System.out.println(sdf.format(c.getTime()));
        return sdf.format(c.getTime());
    }

    /**
     * @Description: 获取当前时间yyyyMMddHHmmss
     * @Param
     * @Return String
     * @Author:youhuiran
     * @Datetime 2017年3月1日 下午7:05:21
     */
    public static String getDateNo(String flag){
        if(StringUtils.isBlank(flag)){
            return DateToString(new Date(),"yyyyMMddHHmmss");
        }else{
            return flag+DateToString(new Date(),"yyyyMMddHHmmss");
        }
    }
    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetweenByDateString(String smdate, String bdate) throws ParseException {
        return daysBetween(DateUtil.StringToDate(smdate),DateUtil.StringToDate(bdate));
    }
    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate
     *            较小的时间
     * @param bdate
     *            较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     *@Description: 把Long类型的时间戳转换成yyyy-MM-dd hh:mm:ss类型时间
     * @Param
     * @Return String
     * @Author:hugaosheng
     * @Datetime 2017年6月7日 下午4:07:21
     */
    public static String longToDate(Long data){
        Date dat=new Date(data);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(dat);
        return dateStr;
    }
    /**
     *
     **@Description: 传入合约起止日期，判断合约是否正常
     * @Param
     * @Return boolean
     * @Author:hugaosheng
     * @CreateTime: 2017年6月9日 上午11:34:31
     * @UpdateTime: 2017年6月9日 上午11:34:31
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean dateIsContract(String startTime,String endTime){
        Date dat=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(dat);
        Date stringToDate2=DateUtil.StringToDate(dateStr);//当前时间2 date
        Date stringToDate = DateUtil.StringToDate(startTime);//开始时间  after
        Date stringToDate3=DateUtil.StringToDate(endTime);//结束时间3  before
        Calendar date = Calendar.getInstance();
        date.setTime(stringToDate2);

        Calendar after = Calendar.getInstance();
        after.setTime(stringToDate);

        Calendar before = Calendar.getInstance();
        before.setTime(stringToDate3);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            //return false;
            if(date.after(after) &&stringToDate2.equals(stringToDate3)){
                return true;
            }else if(stringToDate.equals(stringToDate2)&& date.before(before)){
                return true;
            }else if(stringToDate.equals(stringToDate2)&& date.after(after)){
                return true;
            }else{
                return false;
            }
        }
    }



    /**
     * 获取过去第几天的日期
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(today);
        //System.out.println(result);
        return result;
    }

    /**
     * 计算两个日期之前相差几个周（几个7天）
     * @param startDate
     * @param endDate
     * @return
     */
    public static Object countTwoDayWeek(Object startDate, Object endDate){
        Date start=(Date)startDate;
        Date end = (Date)endDate;
        Calendar cal=Calendar.getInstance();
        cal.setTime(start);
        long time1=cal.getTimeInMillis();
        cal.setTime(end);
        long time2=cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        Double days=Double.parseDouble(String.valueOf(between_days));
        if((days/7)>0 && (days/7)<=1){
            //不满一周的按1周算
            return 1;
        }else if(days/7>1){
            int day=days.intValue();
            if(day%7>0){
                return day/7+1;
            }else{
                return day/7;
            }
        }else if((days/7)==0){
            return 0;
        }else{
            //负数返还null
            return null;
        }
    }

    static int xiqiji(Calendar c){
        int dayForWeek;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;}
        return dayForWeek;
    }

    static Calendar From(Calendar c){
        switch(xiqiji(c)){
            case 1:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-0);
                break;
            case 2:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-1);
                break;
            case 3:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-2);
                break;
            case 4:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-3);
                break;
            case 5:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-4);
                break;
            case 6:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-5);
                break;
            case 7:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)-6);
        }
        return c;

    }
    static Calendar To(Calendar c){
        switch(xiqiji(c)){
            case 1:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+6);
                break;
            case 2:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+5);
                break;
            case 3:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+4);
                break;
            case 4:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+3);
                break;
            case 5:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+2);
                break;
            case 6:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+1);
                break;
            case 7:c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+0);
        }
        return c;

    }

    /**
     * 获取两个日期相差几个自然周
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getWeekbetweenDays(Date startDate, Date endDate){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        c1.setTime(startDate);
        c2.setTime(endDate);

        long cc1=From(c1).getTimeInMillis()/(1000*3600*24);
        long cc2=To(c2).getTimeInMillis()/(1000*3600*24);
        System.out.println((cc2-cc1+1)/7);
        return (int) ((cc2-cc1+1)/7);
    }
    public static int getWeekbetweenDays(String startDate, String endDate){
        return getWeekbetweenDays(DateUtil.StringToDate(startDate),DateUtil.StringToDate(endDate));
    }


    /**
     *  获取两个日期相差的月数
     * @param endDate    较大的日期
     * @param startDate    较小的日期
     * @return  如果endDate>startDate返回 月数差 否则返回0
     */
    public static int getMonthDiff(Date startDate, Date endDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(endDate);
        c2.setTime(startDate);
        if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
        // 获取月数差值
        int monthInterval =  (month1 + 12) - month2  ;
        if(day1 < day2) monthInterval --;
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }
    public static int getMonthDiff(String startDate, String endDate){
        return getMonthDiff(DateUtil.StringToDate(startDate), DateUtil.StringToDate(endDate));
    }
    public static void main(String[] args) throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        c1.setTime(sdf.parse("2018-11-04"));
        c2.setTime(sdf.parse("2019-01-10"));

        int monthDiff = getMonthDiff(c1.getTime(), c2.getTime());
        System.out.println(monthDiff);

    }

    /**
     * String 转化Calendar
     * @param str
     * @return
     */
    public static Calendar StrToCa(String str){
        Date date;
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(str);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }


    /** 获取本月月初   时间格式：yyyy-MM-dd
     * @return String
     * @author pure
     */
    private static int YEAR;                    // 日期属性：年
    private static int MONTH;                  // 日期属性：月
    public static String thisMonth(Calendar localTime) {
        String strY = null;
        YEAR = localTime.get(Calendar.YEAR);
        MONTH = localTime.get(Calendar.MONTH) + 1;
        strY = MONTH >= 10 ? String.valueOf(MONTH) : ("0" + MONTH);
        return YEAR + "-" + strY + "-01";
    }


    /**
     * 获取本月月末  时间格式：yyyy-MM-dd HH:mm:ss（精确到23:59:59）
     * @param date
     * @return
     */
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String getMaxMonthDate(String date){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateY = dateFormat.format(calendar.getTime());
        String dateM = " 23:59:59";
        System.out.println("date=="+dateY+dateM);
        return dateY+dateM;
    }


    /**
     * 判断两个日期是否在同一个月
     * @param nowCalendar
     * @param beforeCalendar
     * @return
     */
    public static boolean monthEquals(Calendar nowCalendar, Calendar beforeCalendar) {
        int year1 = nowCalendar.get(Calendar.YEAR);
        int year2 = beforeCalendar.get(Calendar.YEAR);
        int month1 = nowCalendar.get(Calendar.MONTH);
        int month2 = beforeCalendar.get(Calendar.MONTH);
        //System.out.println(year1 + "  " + month1);
        //System.out.println(year2 + "  " + month2);
        return  nowCalendar.get(Calendar.YEAR) == beforeCalendar.get(Calendar.YEAR) && nowCalendar.get(Calendar.MONTH) == beforeCalendar.get(Calendar.MONTH);
    }


    /**
     * 获取日期月份
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getMonth(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(date));
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 根据输入日期为星期几
     * @throws ParseException
     */

    public static int dayForWeek(String pTime) throws ParseException{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;

    }

    /**
     * 返回周一 00:00:00
     * @Title: main
     * @Description: TODO
     * @throws ParseException
     * @return: void
     */

    public static String getDays(){

        Date d=new Date();
        String data = null;
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        int dayForWeek;
        try {
            dayForWeek = DateUtil.dayForWeek(DateUtil.DateToString(new Date()));
            if(dayForWeek == 1){
                data = df.format(d)+" 00:00:00";

            }else if (dayForWeek == 2) {

                data = df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000))+" 00:00:00";

            }else if (dayForWeek == 3) {
                data = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000))+" 00:00:00";
            }
            else if (dayForWeek == 4) {
                data = df.format(new Date(d.getTime() - 3 * 24 * 60 * 60 * 1000))+" 00:00:00";
            }
            else if (dayForWeek == 5) {
                data = df.format(new Date(d.getTime() - 4 * 24 * 60 * 60 * 1000))+" 00:00:00";
            }
            else if (dayForWeek == 6) {
                data = df.format(new Date(d.getTime() - 5 * 24 * 60 * 60 * 1000))+" 00:00:00";
            }
            else if (dayForWeek == 7) {
                data = df.format(new Date(d.getTime() - 6 * 24 * 60 * 60 * 1000))+" 00:00:00";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return data;

    }


    /**
     * 当月一号
     * @Title: getMonth
     * @Description: TODO
     * @return
     * @return: String
     */
    public static String getMonth(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c=Calendar.getInstance();//获取当前日期
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(c.getTime())+" 00:00:00";
        return firstDay;

    }


    /**
     * @Title: StringTodata
     * @Description: TODO
     * @param pastDate
     * @return
     * @return: Object
     */
    public static String StringToFront(String pastDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateM = " 00:00:00";
        String format2 = null;
        try {
            Date parse = format.parse(pastDate);

            format2 = format.format(parse);

            System.out.println(format2+dateM);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format2+dateM;
    }
    /**
     *
     * @Title: StringToFront
     * @Description: TODO
     * @param pastDate
     * @return
     * @return: String
     */
    public static String StringToQueen(String pastDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateM = " 23:59:59";
        String format2 = null;
        try {
            Date parse = format.parse(pastDate);

            format2 = format.format(parse);

            System.out.println(format2+dateM);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format2+dateM;
    }

    //获取前月的第一天
    public static String firstDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String firstDays = format.format(cal_1.getTime());
        return firstDays;


    }
    //获取前月的最后一天
    public static String lastDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
        String lastDays = format.format(cale.getTime());
        return lastDays;

    }


    /**
     * 根据传入日期，获取年
     * @param date 日期
     * @return 返回年
     */
    public static String getYear(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 根据传入日期，获取月
     * @param date 日期
     * @return 返回月
     */
    public static String getMonth(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 根据传入日期，获取月
     * @param date 日期
     * @return 返回日
     */
    public static String getDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    /**
     * 获取传入日期是本月第几周
     * @param date 日期
     * @return 返回本月第几周
     */
    public static String getWeekOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH) + "";
    }

    /**
     * 获取传入日期是本年第几季度
     * @param date 日期
     * @return 返回本年第几季度 ： 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     */
    public static String getQuarterOfYear(Date date){
        int season = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        switch (month){
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season + "";
    }

    /**
     * 获取传入日期是周几
     * @param date 传入日期
     * @return 返回是周几
     */
    public static String getWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week_of_year = c.get(Calendar.DAY_OF_WEEK);
        return (week_of_year - 1) + "";
    }
    /**
     * 获取传入日期是周几
     * @param date 传入日期
     * @return 返回是周几
     */
    public static int getWeekDayInt(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week_of_year = c.get(Calendar.DAY_OF_WEEK);
        return (week_of_year - 1);
    }

    /**
     * 根据传入日期获取英文月份
     * @param date 传入日期
     * @return 英文月份 ： november
     */
    public static String monthEnglish(Date date){
        DateFormat df = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return df.format(date).toLowerCase();
    }

    /**
     * 根据传入日期获取英文周几
     * @param date 传入日期
     * @return 英文周几：thursday
     */
    public static String weekEnglish(Date date){
        DateFormat df = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        return df.format(date).toLowerCase();
    }

    /**
     格式化时间
     * @param date
     * @param dateFormater
     */
    public static String dateFormater(Date date, String dateFormater) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormater);
        return format.format(date);
    }

    /**
     * 获取当前日期开始 到 N个自然月后 的天数
     * @param count
     * @return
     */
    public static int getDaysAfterMonth(Date startDate, int count) {
        int sum = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int i = cal.get(Calendar.DATE);
        for (int j = 1; j <= count; j++) {
            cal.add(Calendar.MONTH, 2);
            cal.set(Calendar.DAY_OF_MONTH,0);
            int days = cal.get(Calendar.DATE);
//            System.out.println("天数：" + daysi);
//            System.out.println(DateUtil.DateToString(cal.getTime())+"\n");
            sum += days;
        }
        return sum;
    }




    /**
     * 获取距离当前时间间隔指定天数的日期
     * @param date 当前时间
     * @param interval 间隔天数(正数则是当前时间后的时间，负数则是当前时间前的时间，如date=2018-10-01，interval=3，则返回2018-10-04，反之interval=-3，则返回2018-09-29)
     * @return
     */
    public static Date getCurrentTimeInterval(Date date, int interval){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, interval);
        return calendar.getTime();
    }

    /**
     *  获取指定时间 过几周的天数
     * @param startDate 起始时间
     * @param count 几周
     * @return
     */
    public static int getDaysAfterWeek(String startDate, int count) {
        Date date = DateUtil.StringToDate(startDate);
        int sum = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int i = cal.get(Calendar.DATE);
        for (int j = 1; j <= count; j++) {
            cal.add(Calendar.DAY_OF_WEEK, 2);
            cal.set(Calendar.DAY_OF_MONTH,0);
            int days = cal.get(Calendar.DATE);
//            System.out.println("天数：" + daysi);
//            System.out.println(DateUtil.DateToString(cal.getTime())+"\n");
            sum += days;
        }
        return sum;
    }

    /**
     * 获取当前日期是一年的第几周
     * 一年的最后不满一周的天数会归到下一年的第一周
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 每周的第一天和最后一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat,int flag) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date date = new SimpleDateFormat(dateFormat).parse(dataStr);
        cal.setTime(date);
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        if(flag == 0 && date.after(cal.getTime())){
            data1 = new SimpleDateFormat(resultDateFormat).format(DateUtil.StringToDate(dataStr));
        }
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        return data1 + "_" + data2;

    }
    /**
     * 获取指定日期所在周的第一天和最后一天,用下划线连接
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String getFirstAndLastOfMonth(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = new SimpleDateFormat(resultDateFormat).format(c.getTime());
//        System.out.println("===============first:"+first);

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat(resultDateFormat).format(ca.getTime());
//        System.out.println("===============last:"+last);
        return first+"~"+last;
    }

    public static String addMonth(Date date, String resultDateFormat, int count){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.MONTH, count);//增加一个月
        String last = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
        return last;
    }
}

