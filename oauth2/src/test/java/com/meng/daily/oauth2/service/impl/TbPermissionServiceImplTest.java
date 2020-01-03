package com.meng.daily.oauth2.service.impl;

import com.meng.daily.oauth2.entity.TbPermission;
import com.meng.daily.oauth2.service.TbPermissionService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:41
 */
@SpringBootTest
class TbPermissionServiceImplTest {
    @Resource
    private TbPermissionService tbPermissionService;
    @Test
    void selectByUserId() {
        List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(37L);
        tbPermissions.forEach(tbPermission -> {
            System.out.println(tbPermission.toString());
        });
        System.out.println();
    }
    @Test
    void selectById(){
        TbPermission tbPermission = tbPermissionService.selectById(37);
        System.out.println(tbPermission.toString());

    }
}