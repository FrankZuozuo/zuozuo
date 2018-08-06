package com.simply.zuozuo.util;


import com.simply.zuozuo.consts.DateTimePattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * # Copyright (c) 2010-2018 Online zuozuo
 * # Copyright (c) 2018 Online zuozuo
 * # @email : m15197447018@gmail.com
 */

/**
 * @author Created by 谭健 on 2018/4/28 0028. 星期六. 8:48.
 * © All Rights Reserved.
 */
public class DateUtils {


//    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS);
//        int month = -1;
//        System.out.println(simpleDateFormat.format(getETDStart(month)));
//        System.out.println(simpleDateFormat.format(getETDEnd(month)));
//        System.out.println(simpleDateFormat.format(getMiddleStart(month)));
//        System.out.println(simpleDateFormat.format(getMiddleEnd(month)));
//        System.out.println(simpleDateFormat.format(getLTDStart(month)));
//        System.out.println(simpleDateFormat.format(getLTDEnd(month)));
//    }

    // --------------------------------------------------------------------
    // 一个月的上中下旬
    // next = 0 是当月，-1是上一个月，1是下一个月，类推

    public static class TD {
        // 上旬
        public static final int ETD = 1;
        // 中旬
        public static final int MIDDLE = 2;
        // 下旬
        public static final int LTD = 3;
    }


    /**
     * 判断某个日期是一个月的上旬，中旬还是下旬
     */
    public static int getTD(Date date) {
        String format = format(date, DateTimePattern.DAY);
        int dayNumber = Integer.valueOf(format);
        if (0 < dayNumber && dayNumber <= 10) {
            return TD.ETD;
        } else if (11 <= dayNumber && dayNumber <= 20) {
            return TD.MIDDLE;
        } else {
            return TD.LTD;
        }
    }

    /**
     * 一个月上旬开始
     */
    public static Date getETDStart(int next) {
        return currentMonthOfFirst(next);
    }

    /**
     * 一个月上旬结束
     */
    public static Date getETDEnd(int next) {
        return new Date(next(10, currentMonthOfFirst(next)).getTime() - 1);
    }

    /**
     * 一个月中旬开始
     */
    public static Date getMiddleStart(int next) {
        return next(10, currentMonthOfFirst(next));
    }

    /**
     * 一个月中旬结束
     */
    public static Date getMiddleEnd(int next) {
        return new Date(next(20, currentMonthOfFirst(next)).getTime() - 1);
    }

    /**
     * 一个月下旬开始
     */
    public static Date getLTDStart(int next) {
        return next(20, currentMonthOfFirst(next));
    }

    /**
     * 一个月下旬结束
     */
    public static Date getLTDEnd(int next) {
        return currentMonthOfLast(next);
    }


    // --------------------------------------------------------------------

    /**
     * 获取某个月有多少天
     */
    public static int getMaxDayByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year - 1);
        calendar.set(Calendar.MONTH, month);
        return calendar.getActualMaximum(Calendar.DATE);
    }


    /**
     * 获取当前多少天后的日期
     */
    public static Date next(Integer day) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(currentDay());
        cld.add(Calendar.DATE, day);
        return cld.getTime();
    }


    /**
     * 获取当前时间指定时间后的时间
     */
    public static Date next(int number, int field, Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(field, number);
        return cld.getTime();
    }


    /**
     * 获取某个日期多少天后的日期
     */
    public static Date next(Integer day, Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.add(Calendar.DATE, day);
        return cld.getTime();
    }


    /**
     * 时间字符串转时间类型
     */
    public static Date parse(String dateStr) {
        try {
            return new SimpleDateFormat().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 时间字符串转时间类型
     */
    public static Date parse(String dateStr, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }


    /**
     * 按照指定格式格式化时间
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    /**
     * 得到一个指定日期 是星期几
     * <p>
     * 兼容 英文版的Linux 操作系统
     *
     * @param date    日期
     * @param pattern 这个日期的格式
     */
    public static String convertToWeek(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        SimpleDateFormat week = new SimpleDateFormat(DateTimePattern.WEEK, Locale.SIMPLIFIED_CHINESE);
        Date parse;
        String result = "";
        try {
            parse = sdf.parse(date);
            result = week.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 当月的最后
     */
    public static Date currentMonthOfLast() {
        return monthOfLast(0, 0);
    }


    /**
     * 当月的最开始
     */
    public static Date currentMonthOfFirst() {
        return monthOfLast(-1, 1);
    }

    /**
     * 某个月的月初
     */
    public static Date currentMonthOfFirst(int next) {
        return monthOfLast(next - 1, 1);
    }

    /**
     * 某个月的月末
     */
    public static Date currentMonthOfLast(int next) {
        return monthOfLast(next, 0);
    }


    /**
     * @param next next + 1 等于0是当月， next 的值代表多少个月后
     * @param last 是月初还是月末，0是月末，1是月初
     */
    public static Date monthOfLast(int next, int last) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, next + 1);
        calendar.set(Calendar.DAY_OF_MONTH, last);
        SimpleDateFormat sdf = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD);
        SimpleDateFormat sdf1 = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS);
        String format;
        if (last == 0) {
            format = sdf.format(calendar.getTime()) + " 23:59:59";
        } else {
            format = sdf.format(calendar.getTime()) + " 00:00:00";
        }
        try {
            return sdf1.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 当前时间
     */
    public static String currentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimePattern.YYYY_MM_DD_HH_MM_SS));
    }


    /**
     * 获取一周的周一
     */
    public static Date currentWeekOfFirst() {
        return convertLocalDateToDate(currentWeek(true));
    }

    /**
     * 获取一周的周一
     */
    public static String currentWeekFirst() {
        SimpleDateFormat sdf = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD);
        return sdf.format(currentWeekOfFirst());
    }


    /**
     * 获取一周的周末
     */
    public static Date currentWeekOfLast() {
        return convertLocalDateToDate(currentWeek(false));
    }

    /**
     * 获取一周的周末
     */
    public static String currentWeekLast() {
        SimpleDateFormat sdf = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD);
        return sdf.format(currentWeekOfLast());
    }


    /**
     * 当天的开始
     */
    public static String currentDay(boolean suffix) {
        return current(suffix, DateTimePattern.YYYY_MM_DD);
    }


    /**
     * 当月的开始
     */
    public static String currentMonth(boolean suffix) {
        return current(suffix, DateTimePattern.YYYY_MM);
    }


    /**
     * 当年的开始
     */
    public static String currentYear(boolean suffix) {
        return current(suffix, DateTimePattern.YEAR);
    }


    /**
     * 当天的开始
     */
    public static Date currentDay() {
        return current(DateTimePattern.YYYY_MM_DD);
    }

    /**
     * 当天的结束
     */
    public static Date currentDayLast() {
        return new Date(next(1).getTime() - 1);
    }


    /**
     * 当月的开始
     */
    public static Date currentMonth() {
        return current(DateTimePattern.YYYY_MM);
    }


    /**
     * 当年的开始
     */
    public static Date currentYear() {
        return current(DateTimePattern.YEAR);
    }


    private static Date current(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS);
        try {
            return sdf.parse(current(true, pattern));
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }


    /**
     * @param suffix  是否需要后缀
     * @param pattern 格式化类型
     */
    private static String current(boolean suffix, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String result = sdf.format(new Date());
        switch (pattern) {
            case DateTimePattern.YYYY_MM_DD:
                if (suffix) {
                    result = sdf.format(new Date()) + " 00:00:00";
                }
                break;
            case DateTimePattern.YYYY_MM:
                if (suffix) {
                    result = sdf.format(new Date()) + "-01 00:00:00";
                }
                break;
            case DateTimePattern.YEAR:
                if (suffix) {
                    result = sdf.format(new Date()) + "-01-01 00:00:00";
                }
                break;
            default:
        }
        return result;
    }


    /**
     * 把Java8的LocalDate转为Date类型
     */
    private static Date convertLocalDateToDate(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }


    /**
     * 获取当前周的时间节点
     *
     * @param isWeekFirst 是获取周一的，否则获取周末
     */
    private static LocalDate currentWeek(boolean isWeekFirst) {
        LocalDate currentTime = LocalDate.now();
        TemporalAdjuster adjuster;
        if (isWeekFirst) {
            adjuster = TemporalAdjusters.ofDateAdjuster(
                    localDate ->
                            localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue())
            );
        } else {
            adjuster = TemporalAdjusters.ofDateAdjuster(
                    localDate ->
                            localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue())
            );
        }
        return currentTime.with(adjuster);
    }


  /*  public static void main(String[] args) throws ParseException {



        SimpleDateFormat format =  new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS);
        System.out.println(format.format(currentMonthOfFirst(0)));
        System.out.println(format.format(currentMonthOfLast(0)));
        System.out.println(format.format(currentMonthOfFirst(-1)));
        System.out.println(format.format(currentMonthOfLast(-1)));
        System.out.println(format.format(currentMonthOfFirst(-2)));
        System.out.println(format.format(currentMonthOfLast(-2)));
        System.out.println(format.format(currentMonthOfFirst(-3)));
        System.out.println(format.format(currentMonthOfLast(-3)));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        SimpleDateFormat sdf1 = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD);
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
        Date parse = sdf1.parse("2018-05-12");
        String format1 = sdf2.format(parse);
        System.out.println(format1);

        System.out.println(currentWeekOfFirst());
        System.out.println(currentWeekOfLast());


        System.out.println(currentWeekFirst());
        System.out.println(currentWeekLast());


        System.out.println();

        System.out.println(currentTime());

        System.out.println();

        System.out.println(listRecordCurrentDay(false));
        System.out.println(listRecordCurrentDay(true));
        System.out.println(currentMonth(true));
        System.out.println(currentMonth(false));
        System.out.println(currentYear(false));
        System.out.println(currentYear(true));

        System.out.println();

        SimpleDateFormat sdf = new SimpleDateFormat(DateTimePattern.YYYY_MM_DD_HH_MM_SS);
        System.out.println(sdf.format(listRecordCurrentDay()));
        System.out.println(sdf.format(currentMonth()));
        System.out.println(sdf.format(currentYear()));

        System.out.println();
        System.out.println(sdf.format(currentMonthOfLast()));
        System.out.println(sdf.format(currentMonthOfFirst()));

        System.out.println();
        System.out.println(sdf.format(currentMonthOfLast(0)));
        System.out.println(sdf.format(currentMonthOfFirst(0)));


    }*/
}
