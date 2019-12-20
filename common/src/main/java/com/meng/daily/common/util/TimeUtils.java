package com.meng.daily.common.util;


import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/19 20:20
 */
public class TimeUtils {
    /**
     * 添加天数
     * @param date
     * @param num
     * @return
     */
    public static Date addDateOfDay(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,num);
        return calendar.getTime();
    }

    /**
     * 今年的第几天
     * @param date
     * @return
     */
    public static Date getDaysOfYears(Date date){
        System.out.println(date);
        long fragmentInMinutes = DateUtils.getFragmentInDays(date,Calendar.YEAR);
        System.out.println(fragmentInMinutes);
        return date;
    }

    public static void main(String[] args) {
        Date date = new Date();
        getDaysOfYears(date);
        try {
            Date date1 = DateUtils.parseDate("2017-09-22", "yyyy-MM-dd");
            System.out.println("date1"+date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
