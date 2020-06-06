package com.meng.daily.basejava.designpattern;

//懒汉模式
public class SingletonDemo2 {
    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
