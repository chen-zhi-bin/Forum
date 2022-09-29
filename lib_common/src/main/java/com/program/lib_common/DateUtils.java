package com.program.lib_common;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {


    public static String timeFormat(String dateTime){
        if (TextUtils.isEmpty(dateTime)){
            return "";
        }
        long timesTemp = 0;
        long currTimeStamp = new Date().getTime();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            Date date = simpleDateFormat.parse(dateTime);
            timesTemp = date != null? date.getTime():null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //毫秒换成秒
        long seconds = (currTimeStamp - timesTemp) / 1000;
        StringBuffer str = new StringBuffer();
        String returnTime ="";
        if (seconds>=0&&seconds<=59){
            returnTime= str.append("刚刚").toString();
        }else if (seconds>=60&&seconds<=3599){
            returnTime = str.append((seconds/60)+"分钟前").toString();
        }else if (seconds>=3600&&seconds<3600*24){
            returnTime =str.append((seconds/3600)+"小时前").toString();
        }else if (seconds>= 3600 * 24 &&seconds<3600*2*24){
            returnTime=str.append("一天前").toString();
        }else if (seconds>=3600*2*24&&seconds<3600*3*24){
            returnTime=str.append("2天前").toString();
        }else if (seconds>=3600*3*24&&seconds<3600*4*24){
            returnTime=str.append("3天前").toString();
        }else {
            if (dateTime != null) {
                returnTime=dateTime.substring(0, 10).toString();
            }
        }
        return returnTime;
    }
}
