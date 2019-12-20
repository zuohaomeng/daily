package com.meng.daily.common.util;

import com.alibaba.fastjson.JSON;
import com.meng.daily.common.test.User;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/19 21:23
 */
public class JsonUtils {
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T json2Object(String object, Class<T> clazz) {
        return JSON.parseObject(object, clazz);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("shis");
        String jsonStr = JsonUtils.toJson(user);
        System.out.println(jsonStr);
        User o = JsonUtils.json2Object(jsonStr, User.class);
        System.out.println(o);
    }
}
