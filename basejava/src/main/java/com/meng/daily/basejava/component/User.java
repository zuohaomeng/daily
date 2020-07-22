package com.meng.daily.basejava.component;

import com.meng.daily.basejava.java8.stream.UserResult;
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

    /**
     * 转化为Result格式
     * @param user   用户
     * @return
     */
    public static UserResult toResult(User user){
        if(user==null){
            return null;
        }
        UserResult userResult = new UserResult();
        userResult.setAge(user.age);
        userResult.setName(user.name);

        return userResult;
    }
}
