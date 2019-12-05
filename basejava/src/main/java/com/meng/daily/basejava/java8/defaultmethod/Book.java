package com.meng.daily.basejava.java8.defaultmethod;

/**
 * @Description: TODO   默认方法
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 11:59
 */
public interface Book {
    default void read(){
        System.out.println("read book");
    }
    //静态方法自动包括默认方法，必须重写body
    static void buy(){
        System.out.println("buy");
    };
    void write();
}
