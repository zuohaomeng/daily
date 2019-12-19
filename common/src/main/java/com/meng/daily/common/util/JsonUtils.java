package com.meng.daily.common.util;

import com.alibaba.fastjson.JSON;
import com.meng.daily.common.test.User;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/19 21:23
 */
public class JsonUtils {
    private JSON json;
    public JSON JSON(){
        return json;
    }
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }
    public static Object json2Object(String object,Class<?> clazz){
        return JSON.parseObject(object, clazz);
    }
    public static void main(String[] args) {
        User user = new User();
        user.setName("shis");
        String jsonstr = JsonUtils.toJson(user);
        System.out.println(jsonstr);
        User o = (User) JsonUtils.json2Object(jsonstr, User.class);
        System.out.println(o);
    }
}
