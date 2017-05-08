package com.baolian.utils;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 *
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM)
     */
    public final static String MONTH_PATTERN = "yyyy-MM";
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        Date date;
        DateFormat sdf = new SimpleDateFormat(pattern);
        date = sdf.parse(dateStr);
        return date;
    }

    public static void main(String[] args) {
        String s = "2017-05";
        try {
            Date date = parse(s, MONTH_PATTERN);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
