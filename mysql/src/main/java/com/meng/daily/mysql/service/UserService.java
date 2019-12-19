package com.meng.daily.mysql.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.daily.mysql.entity.UserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    UserDo getUserByUserId(@Param("userId") Integer userId);

    /**
     * 删除
     * @return
     */
    int delete(Integer userId);
    /**
     * 修改
     */
    int update(Integer userId);

    /**
     * 当前页和每页大小
     * @param current
     * @param size
     * @return
     */
    Page<UserDo> getLists(int current,int size);
    /**
     * count
     */
    int count();
}
