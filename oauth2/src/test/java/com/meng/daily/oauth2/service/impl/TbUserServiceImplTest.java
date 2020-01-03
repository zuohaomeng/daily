package com.meng.daily.oauth2.service.impl;

import com.meng.daily.oauth2.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    @Test
    void getByUsername() {
    }

    @Test
    void getuserbyID() {
        tbUserService.getuserbyID();
    }
}