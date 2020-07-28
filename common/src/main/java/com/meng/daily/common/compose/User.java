package com.meng.daily.common.compose;

import lombok.Data;

import java.io.Serializable;

@Data
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
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.son = son;
    }

}
