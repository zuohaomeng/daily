package com.meng.daily.basejava.designpattern;


//静态内部类
public class SingletonDemo4 {
    private static class InnerSingleton {
        private static SingletonDemo4 instance = new SingletonDemo4();
    }

    private SingletonDemo4() {
    }

    public static SingletonDemo4 getInstance() {
        return InnerSingleton.instance;
    }
}
