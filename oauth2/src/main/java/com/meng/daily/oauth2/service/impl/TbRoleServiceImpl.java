package com.meng.daily.oauth2.service.impl;

import com.meng.daily.oauth2.mapper.TbRoleMapper;
import com.meng.daily.oauth2.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO  角色相关
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:24
 */
@Service
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleMapper tbRoleMapper;
}
