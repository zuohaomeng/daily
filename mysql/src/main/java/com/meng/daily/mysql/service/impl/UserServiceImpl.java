package com.meng.daily.mysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meng.daily.mysql.entity.UserDo;
import com.meng.daily.mysql.mapper.UserMapper;
import com.meng.daily.mysql.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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

    @Override
    public Page<UserDo> getLists(int current,int size) {
        Page<UserDo> page = new Page();
        Page<UserDo> userDoPage = userMapper.selectPage(page, Wrappers.emptyWrapper());
        return userDoPage;
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public List<UserDo> selectBysex() {
        UserDo userDo = new UserDo();
        QueryWrapper<UserDo> sex = Wrappers.query(userDo).eq("sex", 1);
        List<UserDo> userDos = userMapper.selectList(sex);
        return userDos;
    }

    public List<UserDo> getAll(){
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("sex",1);
        List<UserDo> all = userMapper.getAll(wrapper);
        return all;
    }
}
