package com.meng.daily.oauth2.service;

import com.meng.daily.oauth2.entity.TbUser;

/**
 * @Description: TODO  用户相关
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:23
 */
public interface TbUserService {
    TbUser getByUsername(String username);
}
