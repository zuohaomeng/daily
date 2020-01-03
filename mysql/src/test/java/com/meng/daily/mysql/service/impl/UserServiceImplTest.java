package com.meng.daily.mysql.service.impl;

import com.meng.daily.mysql.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO  UserServiceImplTest
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 19:42
 */
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    void insertUser() {
    }

    @Test
    void getUserByUserId() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getLists() {
    }

    @Test
    void count() {
    }

    @Test
    void selectBysex() {
    }

    @Test
    void getAll() {
    }

    @Test
    void selectOneBySex() {
        System.out.println(userService.selectOneBySex(0));
    }
}