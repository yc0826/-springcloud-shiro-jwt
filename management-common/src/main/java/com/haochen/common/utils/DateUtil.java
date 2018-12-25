package com.haochen.common.utils;


import com.haochen.common.exception.SystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 字符串公共工具类
 * <br>提供关于字符串处理的公用方法
 * <li> 按照指定格式格式化日期并作为字符串返回
 * <li> 将字符串数组或者容器转换为sql语句中in子句的形式。
 *
 * @author slx
 * @version 1.0
 * @date 2009-5-14 下午05:21:42
 */
public class DateUtil {
    public final static Logger logger = LogManager.getLogger(DateUtil.class);


    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public final static String FORMAT_DATE_DEFAULT = "yyyy-MM-dd";

    public final static String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";

    public final static String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";

    public final static String FORMAT_DATE_PATTERN_1 = "yyyy/MM/dd";

    public final static String FORMAT_DATE_PATTERN_2 = "yyyy/M/dd";

    public final static String FORMAT_DATE_PATTERN_3 = "yyyy/MM/d";

    public final static String FORMAT_DATE_PATTERN_4 = "yyyy/M/d";

    public final static String FORMAT_DATE_YYYY_MM_DD_HHMMSS = "yyyyMMddHHmmss";

    public final static String FORMAT_DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_DATE_YYYY_MM_DD_HHMM = "yyyy-MM-dd HHmm";

    public final static String FORMAT_DATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public final static String FORMAT_DATE_HH_MM = "HH:mm";

    public final static String FORMAT_DATE_HH_MM_SS = "HH:mm:ss";

    public final static String FORMAT_DATE_HHMM = "HHmm";

    public final static String FORMAT_DATE_HHMMSS = "HHmmss";

    public static final String FORMAT_DATE_YYMMDD = "yyMMdd";

    public static final String FORMAT_WORK_TIME = "yyyy-MM-dd HHmmss";

    public static final String FORMAT_DATE_YYYY_MM_DDHHMMSS = "yyyy-MM-ddHHmmss";
    /**
     * 锁对象
     */
    private static final Object LOCK_OBJ = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (LOCK_OBJ) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern));
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parseToDate(String dateStr, String pattern) {
        try {
            return getSdf(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 把int的20170812的日期，转换成toPattern的字符串格式
     *
     * @param dateInt
     * @param pattern
     * @param toPattern
     * @return
     * @throws ParseException
     */
    public static String parseIntToString(String dateInt, String pattern, String toPattern) {

        Date date = null;
        try {
            date = getSdf(pattern).parse(dateInt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(date, toPattern);
    }

    public static String parseInt8ToString(Integer dateInt, String toPattern) {
        if (dateInt == null) {
            return "";
        }
        String dateString = dateInt.toString();
        return parseIntToString(dateString, "yyyyMMdd", toPattern);
    }
    /**
     * 把int的20170812的日期，转换成toPattern的字符串格式
     *
     * @param dateInt
     * @param pattern
     * @param toPattern
     * @return
     * @throws ParseException
     */
    public static Date parseIntToDate(String dateInt, String pattern, String toPattern) throws ParseException {
        return getSdf(pattern).parse(dateInt);
    }
    /**
     * 比较两个时间是否相等。
     *
     * @param d1 时间1
     * @param d2 时间2
     * @return 相等则true。因为数据库中读出的数据为Timestamp类型(Date的子类)，
     * 当它与Date类型进行比较时,总是为false,即使是同一个时间.因此写了这个方法,用于兼容这两种类型的时间比较.
     * @author slx
     * @date 2009-7-13 上午10:08:52
     * @modifyNote
     */
    public static boolean equalsDate(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() == d2.getTime();
        }
        return false;
    }

    /**
     * 判断后面的一天是否是前面一天的下一天
     *
     * @param day     基准日期
     * @param nextDay 比较日期
     * @return 如果比较日期是基准日期的下一天则返回true，否则为false
     * @author slx
     */
    public static boolean isNextDay(Date day, Date nextDay) {
        return (getBetweenDays(day, nextDay) == -1);
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param day
     * @param otherDay
     * @author slx
     */
    public static boolean isSameDayxxxxxxxx(Date day, Date otherDay) {
        return (getBetweenDays(day, otherDay) == 0);
    }

    /**
     * 计算两个日期相差的天数.不满24小时不算做一天
     *
     * @param fDate 日期1
     * @param sDate 日期2
     * @return 日期1 - 日期2 的差
     * @author slx
     * @date 2009-7-10 下午03:15:54
     * @modifyNote
     */
    public static int getBetweenDays(Date fDate, Date sDate) {
        return (int) ((fDate.getTime() - sDate.getTime()) / 86400000L);
    }
    /**
     * 计算两个日期相差的天数.不满24小时不算做一天
     *
     * @param fDate
     * @param sDate
     * @return
     * @throws SystemException
     */
    public static int getBetweenDays(Integer fDate, Integer sDate) throws SystemException {
        Date coutDate = new Date();
        Date cinDate = new Date();
        try {
            cinDate = DateUtil.parseToDate(fDate.toString(), "yyyyMMdd");
        } catch (Exception e) {
            logger.error("转换开始时间出错", e);
            throw new SystemException("转换开始时间出错");
        }
        try {
            coutDate = DateUtil.parseToDate(sDate.toString(), "yyyyMMdd");
        } catch (Exception e) {
            logger.error("转换结束时间出错", e);
            throw new SystemException("转换结束时间出错");
        }

        return (int) ((coutDate.getTime() - cinDate.getTime()) / 86400000L);
    }

    /**
     * 日期相加指定年
     *
     * @param date     日期
     * @param addYears 要添加的年数
     * @return 相加后的日期
     * @author slx
     * @date 2009-9-10 上午10:26:22
     * @modifyNote
     */
    public static Date addYears(Date date, int addYears) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.YEAR, addYears);
        return calender.getTime();
    }

    /**
     * 加指定月
     *
     * @param date      日期
     * @param addMonths 月数
     * @return 相加后的日期
     * @author slx
     * @date 2009-9-10 上午10:26:57
     * @modifyNote
     */
    public static Date addMonth(Date date, int addMonths) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, addMonths);
        return calender.getTime();
    }

    /**
     * 加指定天数
     *
     * @param date    日期
     * @param addDays 天数
     * @return 相加后的日期
     * @author slx
     * @date 2009-9-10 上午10:27:22
     * @modifyNote
     */
    public static Date addDay(Date date, int addDays) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.DAY_OF_YEAR, addDays);
        return calender.getTime();
    }

    /**
     * 得到一年的第一天
     *
     * @param year 年
     * @return 一年的第一天
     * @author slx
     * @date 2009-9-10 上午11:14:23
     * @modifyNote
     */
    public static Date getFirstDateOfYear(int year) {
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.DAY_OF_YEAR, calender.getActualMinimum(Calendar.DAY_OF_YEAR));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 得到一年的最后一天
     *
     * @param year 年
     * @return 一年的最后一天
     * @author slx
     * @date 2009-9-10 上午11:14:42
     * @modifyNote
     */
    public static Date getLastDateOfYear(int year) {
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.DAY_OF_YEAR, calender.getActualMaximum(Calendar.DAY_OF_YEAR));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 判断当前日期是否是所在月份的最后一天
     *
     * @param date 日期
     * @return 是最后一天为 true
     * @author slx
     * @date 2009-9-10 上午10:54:36
     * @modifyNote
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        int day = calender.get(Calendar.DAY_OF_MONTH);
        int lastDay = calender.getActualMaximum(Calendar.DAY_OF_MONTH);
        return day == lastDay;
    }

    /**
     * 得到指定月的最后一天
     *
     * @param year  年
     * @param month 月
     * @return 最后一天
     * @author slx
     * @date 2009-9-10 上午11:09:56
     * @modifyNote
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar calender = Calendar.getInstance();
        calender.set(year, month - 1, 1);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 得到日期所在月的最后一天
     *
     * @param date 日期
     * @return 所在月的最后一天
     * @author slx
     * @date 2009-9-10 上午10:54:25
     * @modifyNote
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 设置到当前月的最后时刻
     *
     * @param calender
     * @author slx
     * @date 2010-10-18 上午11:04:56
     * @modifyNote
     */
    private static void setEndTimeOfDay(Calendar calender) {
        calender.set(Calendar.HOUR_OF_DAY, calender.getActualMaximum(Calendar.HOUR_OF_DAY));
        calender.set(Calendar.MINUTE, calender.getActualMaximum(Calendar.MINUTE));
        calender.set(Calendar.SECOND, calender.getActualMaximum(Calendar.SECOND));
        calender.set(Calendar.MILLISECOND, calender.getActualMaximum(Calendar.MILLISECOND));
    }

    /**
     * 得到指定月的第一天
     *
     * @param year  年
     * @param month 月
     * @return 第一天
     * @author slx
     * @date 2009-9-10 上午11:09:56
     * @modifyNote
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar calender = Calendar.getInstance();
        calender.set(year, month - 1, 1);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMinimum(Calendar.DAY_OF_MONTH));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 得到指定日期所在月的第一天
     *
     * @param date 日期
     * @return 第一天
     * @author slx
     * @date 2009-9-10 上午11:09:56
     * @modifyNote
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMinimum(Calendar.DAY_OF_MONTH));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 设置到月份开始的时刻
     *
     * @param calender
     * @author slx
     * @date 2010-10-18 上午11:06:12
     * @modifyNote
     */
    private static void setStartTimeOfDay(Calendar calender) {
        calender.set(Calendar.HOUR_OF_DAY, calender.getActualMinimum(Calendar.HOUR_OF_DAY));
        calender.set(Calendar.MINUTE, calender.getActualMinimum(Calendar.MINUTE));
        calender.set(Calendar.SECOND, calender.getActualMinimum(Calendar.SECOND));
        calender.set(Calendar.MILLISECOND, calender.getActualMinimum(Calendar.MILLISECOND));
    }

    public static Date getStartTimeOfDay(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        setEndTimeOfDay(calender);
        return calender.getTime();

    }

    /**
     * 得到当前年月
     *
     * @return 格式：2008-11
     * @throws ParseException
     * @author yongtree
     * @date 2008-11-22 上午11:25:24
     */
    public static String getThisYearMonth() {
        return getYearMonth(new Date());
    }

    /**
     * 得到年月
     *
     * @return 格式：2008-11
     * @throws ParseException
     * @author slx
     * @date 2010年4月16日13:09:23
     */
    public static String getYearMonth(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        return (today.get(Calendar.YEAR)) + "-" + ((today.get(Calendar.MONTH) + 1) >= 10 ? (today.get(Calendar.MONTH) + 1) : ("0" + (today.get(Calendar.MONTH) + 1)));
    }

    public static String getYear() {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        return String.valueOf(today.get(Calendar.YEAR));
    }

    public static String getMonth() {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        return String.valueOf(today.get(Calendar.MONTH) + 1);
    }

    public static String getDate() {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        return String.valueOf(today.get(Calendar.DATE));
    }


    /**
     * 计算两个日期之间相差的月份数
     * <br> 日期顺序不分先后不会返回负数
     * <br> 不足一个月不算做一个月
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 月数
     * @author slx
     * @date 2010年4月16日11:32:51
     * @modifyNote
     */
    public static int getBetweenMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        Calendar objCalendarDate1 = Calendar.getInstance();
        objCalendarDate1.setTime(date1);

        Calendar objCalendarDate2 = Calendar.getInstance();
        objCalendarDate2.setTime(date2);

        if (objCalendarDate2.equals(objCalendarDate1)) {
            return 0;
        }

        if (objCalendarDate1.after(objCalendarDate2)) {
            Calendar temp = objCalendarDate1;
            objCalendarDate1 = objCalendarDate2;
            objCalendarDate2 = temp;
        }
        if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH)) {
            flag = 1;
        }


        if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR)) {
            iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR))
                    * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
                    - objCalendarDate1.get(Calendar.MONTH);
        } else {
            iMonth = objCalendarDate2.get(Calendar.MONTH)
                    - objCalendarDate1.get(Calendar.MONTH) - flag;
        }


        return iMonth;
    }

    /**
     * 计算两个日期之间相差的年份数
     * <br> 日期顺序不分先后不会返回负数
     * <br> 不足一个年不算做一个年
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 年数
     * @author slx
     * @date 2010年4月16日12:01:46
     * @modifyNote
     */
    public static int getBetweenYears(Date date1, Date date2) {
        return getBetweenMonths(date1, date2) / 12;
    }


    public static boolean before(Date date1, Date date2) {
        if (date1 == null
                || date2 == null) {
            return false;
        }
        Calendar c1 = new GregorianCalendar();
        c1.setTime(date1);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(date2);
        return c1.before(c2);
    }

    public static boolean after(Date date1, Date date2) {
        if (date1 == null
                || date2 == null) {
            return false;
        }
        Calendar c1 = new GregorianCalendar();
        c1.setTime(date1);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(date2);
        return c1.after(c2);
    }

    /**
     * 当前时间是否失效
     *
     * @param expiresDate
     * @return
     */
    public static boolean isExpires(Date expiresDate) {
        return after(new Date(), expiresDate);
    }

    /**
     * 是否同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 判断两个日期是否相差一天
     *
     * @return
     */
    public static boolean isYesterday(Date oldDate, Date newDate) {
        Calendar oldCal = Calendar.getInstance();
        Calendar newCal = Calendar.getInstance();

        oldCal.setTime(oldDate);
        newCal.setTime(newDate);
        return Math.abs(newCal.get(Calendar.DAY_OF_YEAR) - oldCal.get(Calendar.DAY_OF_YEAR)) == 1;
    }

    /**
     * 校验日期格式是否合法
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean isValidDate(String date, String format) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static Integer getInt8Value(String date, String pattern) {
        Date d = DateUtil.parse(date, pattern);
        return getInt8Value(d);
    }

    public static Integer getInt8Value(Date date) {
        String year = getIntYear(date).toString();
        String month = getIntMonth(date).toString();
        String date1 = getIntDate(date).toString();
        if (month.length() < 2) {
            month = "0" + month;
        }
        if (date1.length() < 2) {
            date1 = "0" + date1;
        }
        return Integer.parseInt(year + month + date1);
    }

    public static Integer getIntYear(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        return today.get(Calendar.YEAR);
    }

    public static Integer getIntMonth(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        return today.get(Calendar.MONTH) + 1;
    }

    public static Integer getIntDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        return today.get(Calendar.DATE);
    }

    public static String getStringDate(Integer date) {
        String newDate = null;
        if (date.toString().length() == 8) {
            newDate = date.toString().substring(0, 4) + "-" + date.toString().substring(4, 6) + "-" + date.toString().substring(6, 8);
        }
        return newDate;
    }

    public final static int compareDate(String stringValue1, Date date2)
            throws ParseException {
        Date date1 = tryParse(stringValue1);
        if (date1 == null) {
            throw new ParseException("Can not parse " + stringValue1
                    + " to Date.", 0);
        }

        if (date2 == null) {
            throw new ParseException("Can not parse " + stringValue1
                    + " to Date.", 0);
        }

        return date1.compareTo(date2);
    }

    public final static int compareDate(String stringValue1, String stringValue2)
            throws ParseException {
        Date date1 = tryParse(stringValue1);
        if (date1 == null) {
            throw new ParseException("Can not parse " + stringValue1
                    + " to Date.", 0);
        }

        Date date2 = tryParse(stringValue2);
        if (date2 == null) {
            throw new ParseException("Can not parse " + stringValue1
                    + " to Date.", 0);
        }

        return date1.compareTo(date2);
    }

    public final static Date tryParse(String stringValue) {
        Date date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYYMMDD);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD_HHMMSS);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD_HH_MM_SS);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_YYYY_MM_DD_HHMM);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_1);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_2);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_3);
        if (date != null) {
            return date;
        }
        date = parse(stringValue, FORMAT_DATE_PATTERN_4);
        if (date != null) {
            return date;
        }
        return date;
    }

    public final static Date parse(String stringValue, String formatPattern) {
        return parseToDate(stringValue, formatPattern);
    }

    public final static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 计算2个日期差多少年多少月多少天
     *
     * @param calendarBirth
     * @param calendarNow
     * @return
     */
    public static int[] getNeturalAge(Calendar calendarBirth, Calendar calendarNow) {
        int diffYears = 0, diffMonths, diffDays;
        int dayOfBirth = calendarBirth.get(Calendar.DAY_OF_MONTH);
        int dayOfNow = calendarNow.get(Calendar.DAY_OF_MONTH);
        if (dayOfBirth <= dayOfNow) {
            diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
            diffDays = dayOfNow - dayOfBirth;
            if (diffMonths == 0) {
                diffDays++;
            }
        } else {
            if (isEndOfMonth(calendarBirth)) {
                if (isEndOfMonth(calendarNow)) {
                    diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
                    diffDays = 0;
                } else {
                    calendarNow.add(Calendar.MONTH, -1);
                    diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
                    diffDays = dayOfNow + 1;
                }
            } else {
                if (isEndOfMonth(calendarNow)) {
                    diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
                    diffDays = 0;
                } else {
                    calendarNow.add(Calendar.MONTH, -1);// 上个月
                    diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
                    // 获取上个月最大的一天
                    int maxDayOfLastMonth = calendarNow.getActualMaximum(Calendar.DAY_OF_MONTH);
                    if (maxDayOfLastMonth > dayOfBirth) {
                        diffDays = maxDayOfLastMonth - dayOfBirth + dayOfNow;
                    } else {
                        diffDays = dayOfNow;
                    }
                }
            }
        }
        // 计算月份时，没有考虑年
        diffYears = diffMonths / 12;
        diffMonths = diffMonths % 12;
        return new int[]{diffYears, diffMonths, diffDays};
    }

    /**
     * 获取两个日历的月份之差
     *
     * @param calendarBirth
     * @param calendarNow
     * @return
     */
    public static int getMonthsOfAge(Calendar calendarBirth,
                                     Calendar calendarNow) {
        return (calendarNow.get(Calendar.YEAR) - calendarBirth
                .get(Calendar.YEAR)) * 12 + calendarNow.get(Calendar.MONTH)
                - calendarBirth.get(Calendar.MONTH);
    }

    /**
     * 判断这一天是否是月底
     *
     * @param calendar
     * @return
     */
    public static boolean isEndOfMonth(Calendar calendar) {
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<String> getDatesBetweenTwoDate(String beginDate, String endDate) {
        List<String> lDate = new ArrayList<>();
        lDate.add(beginDate);//把开始时间加入集合
        Date d1 = parseToDate(beginDate, DATE_PATTERN);
        Date d2 = parseToDate(endDate, DATE_PATTERN);
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(d1);
        while (true) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (d2.after(cal.getTime())) {
                lDate.add(formatDate(cal.getTime(), DATE_PATTERN));
            } else {
                break;
            }
        }
        lDate.add(endDate);//把结束时间加入集合
        return lDate;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<String> getDatesBetweenTwoDate(String beginDate, String endDate, String fromDatePattern, String toDatePattern) {
        List<String> lDate = new ArrayList<>();
        //把开始时间加入集合
        lDate.add(beginDate);
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = parseToDate(beginDate, fromDatePattern);
            d2 = parseToDate(endDate, fromDatePattern);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(d1);
        while (true) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (d2.after(cal.getTime())) {
                lDate.add(formatDate(cal.getTime(), toDatePattern));
            } else {
                break;
            }
        }
        //把结束时间加入集合
        lDate.add(endDate);
        return lDate;
    }
}

