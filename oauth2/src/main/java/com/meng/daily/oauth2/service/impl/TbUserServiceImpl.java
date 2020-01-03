package com.meng.daily.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meng.daily.oauth2.entity.TbUser;
import com.meng.daily.oauth2.mapper.TbUserMapper;
import com.meng.daily.oauth2.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:24
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.selectOne(new LambdaQueryWrapper<TbUser>().eq(TbUser::getUsername,username).last("limit 1"));
    }
}
