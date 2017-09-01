package com.zkp.com.myapplication.utils;

import java.util.Calendar;

/**
 * 日期工具类
 *
 * @author ZKP
 *         created at:2017/7/19 11:07
 */

public class DateUtils {

    public static String getTodayStr(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (month < 10 && day < 10) {
            return String.format("0%s0%s", month, day);
        } else if (month < 10) {
            return String.format("0%s%s", month, day);
        } else if (day < 10) {
            return String.format("%s0%s", month, day);
        } else {
            return String.format("%s%s", month, day);
        }
    }
}
