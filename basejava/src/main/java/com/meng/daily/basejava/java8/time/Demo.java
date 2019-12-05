package com.meng.daily.basejava.java8.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 14:02
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        System.out.println(now);
        System.out.println(now1);
        Date date = new Date();
        System.out.println(date.getTime());
        TimeUnit.SECONDS.sleep(10);
        System.out.println(date.getTime());


    }
}
