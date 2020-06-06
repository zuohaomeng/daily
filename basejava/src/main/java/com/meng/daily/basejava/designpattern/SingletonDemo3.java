package com.meng.daily.basejava.designpattern;

//双重校验锁
public class SingletonDemo3 {
    private volatile static SingletonDemo3 instance = null;

    private SingletonDemo3() {

    }

    public static SingletonDemo3 getInstance() {
        if (instance == null) {

            synchronized (SingletonDemo3.class){
                if(instance == null){
                    instance = new SingletonDemo3();
                }
            }
        }

        return instance;
    }
}

