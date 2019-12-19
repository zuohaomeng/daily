package com.meng.daily.mysql.service;

import com.meng.daily.mysql.entity.UserDo;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/19 9:57
 */
public interface UserService {
    /**
     * 添加
     * @param user
     */
    void insertUser(UserDo user);

    /**
     * 删除
     * @param userId
     * @return
     */
    UserDo getUserByUserId(Integer userId);

    /**
     * 删除
     * @return
     */
    int delete(Integer userId);
    /**
     * 修改
     */
    int update(Integer userId);
}
