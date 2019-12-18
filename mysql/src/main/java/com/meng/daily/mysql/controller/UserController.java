package com.meng.daily.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 16:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
