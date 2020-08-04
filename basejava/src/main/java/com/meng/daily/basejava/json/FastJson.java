package com.meng.daily.basejava.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.meng.daily.basejava.component.User;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-03 16:26
 */
public class FastJson {
    private final static int COUNT = 1;
    static User user = new User();

    static Gson gson = new Gson();
    static ObjectMapper objectMapper = new ObjectMapper();
    public FastJson() {
        JSON.toJSONString(user);
        user.setAge(32);
        user.setName("小王");
    }

    public static void main(String[] args) throws Exception{
        long start1 = System.currentTimeMillis();
        fastJson();
        long end1 = System.currentTimeMillis();
        System.out.println("fastjson:"+(end1-start1));


        long start2 = System.currentTimeMillis();
        gson();
        long end2 = System.currentTimeMillis();
        System.out.println("gson:"+(end2-start2));


        long start3 = System.currentTimeMillis();
        jackSon();
        long end3 = System.currentTimeMillis();
        System.out.println("jackSon:"+(end3-start3));
    }

    public static void fastJson() {
        for (int i = 0; i < COUNT; i++) {
            JSON.toJSONString(user);
        }
    }

    public static void gson() {
        for (int i = 0; i < COUNT; i++) {
            gson.toJson(user);
        }
    }

    public static void jackSon() throws Exception {
        for (int i = 0; i < COUNT; i++) {
            objectMapper.writeValueAsString(user);
        }
    }
}
