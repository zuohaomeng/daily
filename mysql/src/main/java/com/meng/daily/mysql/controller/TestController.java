package com.meng.daily.mysql.controller;

import com.meng.daily.common.base.ResponseModel;
import com.meng.daily.mysql.entity.UserDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/20 12:47
 */
@RestController
@RequestMapping("/test")
public class TestController {
    Random random = new Random();
    @GetMapping("one")
    public ResponseModel one(){
        UserDo user1 = UserDo.builder().name("李四").sex(1).build();
        System.out.println("添加2一2个1");
        return ResponseModel.SUCCESS(user1);
    }
    @GetMapping("list")
    public ResponseModel list(){
        UserDo user1 = UserDo.builder().email(random.nextInt(1000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user2 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        return ResponseModel.SUCCESS(list);
    }
}
