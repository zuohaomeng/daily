package com.meng.daily.mysql.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.meng.daily.mysql.entity.UserDo;
import com.meng.daily.mysql.mapper.UserMapper;
import com.meng.daily.mysql.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/19 9:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(UserDo user) {
        Random random = new Random();
        if(user==null){
            user = UserDo.builder()
                    .email(random.nextInt(10000000)+"@qq.com")
                    .name("王三")
                    .sex(1)
                    .build();
        }
        userMapper.insert(user);
    }

    @Override
    public UserDo getUserByUserId(Integer userId) {
        UserDo userDo = userMapper.selectById(userId);
        return userDo;
    }

    @Override
    public int delete(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int update(Integer userId) {
        UserDo userDo = userMapper.selectById(userId);
        userDo.setUpdateTime(new Date());
        int i = userMapper.updateById(userDo);
        return i;
    }
}
