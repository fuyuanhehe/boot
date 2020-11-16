package com.boot.boot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CCtticDateUtils {
    /**
     * 说明：format日期数据，返回字符串
     * */
    public static String formatDate(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取当前时间字符串
     * @param pattern
     * @return
     */
    public static String presentDay(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static String presentDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }
    /**
     * 获取时间戳
     */
    public static Long getTimeStamp(){
        return new Date().getTime();
    }

    /**
     * 时间戳转data
     */
    public static Date getData(Long time){
        return new Date(time);
    }




}
