package com.meng.daily.basejava.test;

import lombok.Data;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-07-18 10:56
 */

@Data
public class User {
    private String name;

    public static void main(String[] args) {
        User user = new User();
        user.setName("2312");
        System.out.println(user);
    }
}
