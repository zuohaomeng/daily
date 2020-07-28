package com.meng.daily.common.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class User2 implements Serializable {
    public String name;
    public int age;
    public User son;

    public User2() {
    }

    public User2(String name, int age, User son) {
        this.name = name;
        this.age = age;
        this.son = son;
    }
    public User2(String name, int age) {
        this.name = name;
        this.age = age;
        this.son = son;
    }

}
