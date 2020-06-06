package com.meng.daily.basejava.designpattern;


import com.meng.daily.basejava.component.User;

/**
 * 枚举单例模式
 */
public enum SingletonDemo6 {
    USER,USER2;

    private User user;

    private SingletonDemo6() {
        user = new User("小明", 22, new User());
    }

    public User getInstance() {
        return user;
    }
}
