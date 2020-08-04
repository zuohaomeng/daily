package com.meng.daily.basejava.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.meng.daily.basejava.component.User;
import springfox.documentation.spring.web.json.Json;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-03 16:48
 */
public class CyclicJson {
    static User son = new User();
    static User father = new User();
    static {
        son.setName("大头儿子");
        son.setAge(12);
        father.setAge(35);
        father.setName("小头爸爸");
        son.setFather(father);
        father.setSon(son);
    }
    public static void main(String[] args) {
//        System.out.println(son);
//        String s = new Gson().toJson(son);
//        System.out.println(s);

        String s2 = JSON.toJSONString(son);
        System.out.println(s2);

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String s3 = objectMapper.writeValueAsString(son);
//            System.out.println(s3);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
