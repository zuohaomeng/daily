package com.meng.daily.basejava.designpattern;

import com.meng.daily.basejava.component.User;

public class TestMain {
    public static void main(String[] args) {
        User instance1 = SingletonDemo6.USER.getInstance();
        User instance2 = SingletonDemo6.USER2.getInstance();
        System.out.println(instance1==instance2);
    }
}
