package com.meng.daily.basejava.java8.time;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 14:02
 */
public class Demo implements Serializable {
    public static void main(String[] args) throws Exception {
        date2localDateTime();
    }

    public static void calendarToDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        //重新设置时间
        calendar.setTime(date);
    }

    public static void dateToCalender() {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
    }

    public static void localDateTime2Date() {
        LocalDateTime dateTime = LocalDateTime.now();
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void date2localDateTime(){
        Date date = new Date();
        LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(dateTime.toString());
    }


    public static void dateToString() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println(str);
    }

    public static void stringToDate() throws ParseException {
        String strDate = "2020-06-08 11:47:02";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(strDate);
    }

    public static void changeDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_WEEK, 11);
        System.out.println(format.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, 41);
        System.out.println(format.format(calendar.getTime()));
        calendar.add(Calendar.YEAR, -1);
        System.out.println(format.format(calendar.getTime()));
    }
}
