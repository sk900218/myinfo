package com.myinfo.base.utils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：日期工具类<br>
 */
public class DateUtil {

    private static Logger logger = LogManager.getLogger(DateUtil.class);

    public static final String FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_STANDARD_MIN = "yyyy-MM-dd HH:mm";

    public static final String FORMAT_STANDARD_SIMPLE = "yyyyMMddHHmmss";

    public static final String FORMAT_YYMMDDHHMM = "yyyyMMddHHmm";

    public static final String FORMAT_STANDARD_DAY = "yyyy-MM-dd";

    public static final String FORMAT_YYYY$M$D = "yyyy年M月d日";

    public static final String FORMAT_ACCURATE_DAY = "yyyyMMdd";

    public static final String FORMAT_CLEAR_HOUR = "yyyy-MM-dd 00:00:00";

    public static final String FORMAT_CLEAR_MINUTE = "yyyy-MM-dd HH:00:00";

    public static final String FORMAT_CLEAR_DAY = "yyyy-MM-01 00:00:00";

    public static final String FORMAT_CLEAR_YEAR = "yyyy";

    public static final String FORMAT_BOMC_STANDARD = "yyyy-MM-dd'T'HH:mm:ss";

    // 以 Z结尾的 日志格式，如 20101224013400Z
    public static final String FORMAT_Z_DATE = "yyyyMMddHHmmss'Z'";
    // 2010052415240500 16位纯数字日期
    public static final String NUMBER_DATE = "yyyyMMddHHmmssSS";

    /**
     * 日期格式化
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern){
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

    /**
     * 日期格式化
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parse(String dateStr, String pattern){
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        try {
            return sf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("日期格式化异常", e);
        }
        return null;
    }

    /**
     * 日期格式化
     * @param dateStr
     * @param pattern
     * @param toPattern
     * @return
     */
    public static String formatDateToString(String dateStr, String pattern, String toPattern) {
        Date date = parse(dateStr, pattern);
        return format(date, toPattern);
    }

    /**
     * 获取前后几小时的日期字符串
     * @param dateStr 原日期字符串
     * @param pattern 格式化
     * @param n 小数
     * @return
     */
    public static String getNextHour(String dateStr, String pattern, int n) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        long now = 0;
        try {
            now = sf.parse(dateStr).getTime();
        } catch (ParseException e) {
            logger.error("获取前后几小时的日期字符串异常", e);
        }
        Date date = new Date(now + (1000 * 60 * 60 * n));
        return sf.format(date);
    }

    /**
     * 获取前后几小时的日期字符串
     * @param date 原日期
     * @param n 小数
     * @return
     */
    public static Date getNextHour(Date date, int n) {
        long now = date.getTime();
        Date newDate = new Date(now + (1000 * 60 * 60 * n));
        return newDate;
    }

    /**
     * 获取前后几小时的日期字符串
     * @param date 原日期
     * @param n 小数
     * @return
     */
    public static Date getNextHour(Date date, double n) {
        int hour = (int) (n / 1);
        int minute = (int) ((n - hour) * 60);
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hour);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);
        return now.getTime();
    }

    /**
     * 获取前后几分钟的日期字符串
     * @param date 原日期
     * @param n 小数
     * @return
     */
    public static Date getNextMinute(Date date, int n) {
        long now = date.getTime();
        Date newDate = new Date(now + (1000 * 60 * n));
        return newDate;
    }

    /**
     * 获取前后几天的日期
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }

    /**
     * 获取今天的日期字符串
     * @param pattern
     * @return
     */
    public static String getToday(String pattern){
        Calendar cal = Calendar.getInstance();
        return format(cal.getTime(), pattern);
    }

    /**
     * 获取今天的日期
     * @param pattern
     * @return
     */
    public static Date getCurrDate(String pattern){
        return parse(getToday(pattern), pattern);
    }

    /**
     * 获取今年
     * @return
     */
    public static int getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.YEAR);
    }

    /**
     * 将字串类型英文的日期格式转化成日期类型
     * @param strDate
     * @return
     */
    public static Date parseUKDate(String strDate){
        try {
            DateFormat fmt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK);
            return fmt.parse(strDate);
        } catch (ParseException e) {
            logger.error("将字串类型英文的日期格式转化成日期类型出错:" + e.getMessage());
        }
        return null;
    }

    /**
     * 获取昨天的日期字符串
     * @param pattern
     * @return
     */
    public static String getYesterday(String pattern){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return format(cal.getTime(), pattern);
    }

    /**
     * 获取昨天的日期字符串
     * @param pattern
     * @return
     */
    public static String getBeforeday(String pattern, int n){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, n);
        return format(cal.getTime(), pattern);
    }

    /**
     * 获取当前月第一天
     * @return
     */
    public static Date getFirstDay4Month(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取日期所属月份的第一天
     * @param date
     * @return
     */
    public static Date getFirstDay4Month(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 计算两个日期相差的天数
     * @param begin
     * @param end
     * @param pattern
     * @return
     */
    public static int diffDayNum(String begin, String end, String pattern){
        Calendar dar1 = Calendar.getInstance();
        dar1.setTime(parse(begin, pattern));

        Calendar dar2 = Calendar.getInstance();
        dar2.setTime(parse(end, pattern));

        int days = 0;
        while(dar1.before(dar2)){
            days++;
            dar1.add(Calendar.DAY_OF_YEAR, 1);
        }
        return days;
    }

    /**
     * 计算date加上day天，day为负数做减法
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date,int day){
        if (Objects.isNull(date)){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        return calendar.getTime();
    }

    public static int getDiffMinute(String date1, String date2,String pattern) {
        return getDiffMinute(parse(date1,pattern),parse(date2,pattern));
    }


    public static int getDiffMinute(Date date1, Date date2)
    {
        if (date1 == null || date2 == null)
            return 0;

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long diff = time1 - time2;

        Long longValue = new Long(diff / (60 * 1000));

        int di = longValue.intValue();;
        return di;
    }

    /**
     * 指定时间的小时开始
     * @param date
     * @return ... HH:00:00.000
     */
    public static Date hourBegin(final Date date, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        c.set(Calendar.HOUR_OF_DAY, hour);
        return c.getTime();
    }

    /**
     * 获取这一天的开始（yyyy-MM-dd 00:00:00）和结束（yyyy-MM-dd 23:59:59）
     * @param date
     * @return
     */
    public static List<Date> dayStartAndEnd(Date date) {
        List<Date> result = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.HOUR_OF_DAY, 0);
        result.add(c.getTime());
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.HOUR_OF_DAY, 23);
        result.add(c.getTime());
        return result;
    }

    /**
     * 描述：在日期上增加数个整月 <br/>
     * @param date
     * @param n
     * @return <br/>
     * 创建日期：2013-2-4 <br/>
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }




    /**
     * 时间格式补全0 yyyy-MM-dd
     * */
    public static String dateFormatAddAll(String date){
        if(date!=null &&  date.length() != 0){
            if(-1 != date.indexOf("-")){
                String[] data = date.split("-");
                if(data.length>=3){
                    String year = data[0].trim();
                    String month = data[1].trim();
                    String day = data[2].trim();
                    if(month.length()==1){
                        month = "0"+month;
                    }
                    if(day.length()==1){
                        day = "0"+day;
                    }

                    return year+"-"+month+"-"+day;
                }else if (data.length==2) {
                    String year = data[0].trim();
                    String month = data[1].trim();
                    if(month.length()==1){
                        month = "0"+month;
                    }
                    return year+"-"+month;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * 返回给定天的num天后的字符串
     * @param curDay
     * @param dateFormat
     * @param num
     * @return
     */
    public static String getNextDay(String curDay, String dateFormat, int num) {
        SimpleDateFormat sdf = null;
        Calendar cal = null;
        Date date = null;
        String dateStr = null;

        sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(curDay);
            cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, num);
            date = cal.getTime();
            dateStr = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();

            return curDay;
        }

        return dateStr;
    }

    /**
     * 返回给定天的下一天的字符串
     * @param curDay
     * @param dateFormat
     * @return
     */
    public static String getNextDay(String curDay, String dateFormat) {
        SimpleDateFormat sdf = null;
        Calendar cal = null;
        Date date = null;
        String dateStr = null;

        sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(curDay);
            cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            date = cal.getTime();
            dateStr = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return curDay;
        }

        return dateStr;
    }

    /**
     * 解析时间格式 HH:mm YYYY-MM-DD HH:mm:SS格式，在0-4点自动添加1天时间
     * @param str
     * @param toDay
     * @return
     */
    public static Date parseTime(String str, String toDay) {
        if (str != null && !str.equals("") && !str.equals("false")) {
            try {
                if (str.length() == 5 || str.length() == 4) {
                    Date date = new Date();
                    if (toDay != null && !getToday(FORMAT_STANDARD_DAY).equals(toDay)) {
                        date = parse(toDay, FORMAT_STANDARD_DAY);
                    }
                    str = str.replace(":", "");
                    int datetime = Integer.parseInt(str);
                    StringBuilder sb = new StringBuilder();
                    if (datetime < 400 && datetime >= 0) {
                        sb.append(format(addDay(date, 1), FORMAT_STANDARD_DAY));
                    } else {
                        sb.append(toDay);
                    }
                    sb.append(" ").append(str);
                    return new SimpleDateFormat(FORMAT_STANDARD_MIN).parse(sb.toString());
                } else {
                    return new SimpleDateFormat(FORMAT_STANDARD).parse(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }


    /**
     * 在日期上增加数个整年
     *
     * @param date
     *            日期
     * @param n
     *            年数
     * @return
     */
    public static Date addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }


    /**
     * 判断时间是否在某两个范围内
     * @param time 时间
     * @param from 开始时间
     * @param to 结束时间
     * @return
     */
    public static boolean between(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将日期设置为这一天的最早
     * @param date
     * @return
     */
    public static Date dateFirst(Date date) {
        String d = format(date, "yyyy-MM-dd");
        return parse(d + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期设置为这一天的最早
     * @param date
     * @return
     */
    public static String dateFirst(String date) throws Exception {
        Date d = parse(date + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
        return format(d, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期设置为这一天的最晚
     * @param date
     * @return
     */
    public static Date dateLast(Date date) {
        String d = format(date, "yyyy-MM-dd");
        return parse(d + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期设置为这一天的最晚
     * @param date
     * @return
     */
    public static String dateLast(String date) {
        Date d = parse(date + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        return format(d, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前周第一天
     * 周一~周日
     * @param date
     * @return
     */
    public static Date getWeekStartDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(addDay(date, -1));
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前周最后一天
     * 周一~周日
     * @param date
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(addDay(date, -1));
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time = cal.getTime();
        return parse(new SimpleDateFormat("yyyy-MM-dd").format(time) + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取月开始日期
     * @param date
     * @return Date
     * **/
    public static Date getMonthStart(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time=cal.getTime();
        return parse(new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取月最后一天
     * @param date
     * @return Date
     * **/
    public static Date getMonthEnd(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time=cal.getTime();
        return parse(new SimpleDateFormat("yyyy-MM-dd").format(time)+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

}
