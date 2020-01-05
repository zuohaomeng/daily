package com.meng.daily.oauth2.service.impl;

import com.meng.daily.oauth2.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 21:10
 */
@SpringBootTest
class TbUserServiceImplTest {
    @Resource
    private TbUserService tbUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void getByUsername() {
    }

    @Test
    void getuserbyID() {
        tbUserService.getuserbyID();
    }
    @Test
    void getPassword(){
        System.out.println(bCryptPasswordEncoder.encode("12345"));
    }
}