package com.meng.daily.basejava.component;

import java.io.Serializable;


public class User implements Serializable {
    public String name;
    public int age;
    public User son;

    public User() {
    }

    public User(String name, int age, User son) {
        this.name = name;
        this.age = age;
        this.son = son;
    }
}
