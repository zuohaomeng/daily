package com.meng.daily.basejava.Instrument;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/24 15:26
 */
import java.lang.management.ManagementFactory;

public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
//        System.out.println(Base.class.getClassLoader());
        System.out.println("process");
    }
}
