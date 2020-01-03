package com.meng.daily.oauth2.service;

import com.meng.daily.oauth2.entity.TbPermission;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:23
 */
public interface TbPermissionService {
    /**
     * 根据用户id获取权限
     * @param userId
     * @return
     */
    List<TbPermission> selectByUserId(Long userId);
}
