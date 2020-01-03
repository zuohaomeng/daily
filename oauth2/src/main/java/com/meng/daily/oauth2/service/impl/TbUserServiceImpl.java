package com.meng.daily.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meng.daily.oauth2.entity.TbUser;
import com.meng.daily.oauth2.mapper.TbUserMapper;
import com.meng.daily.oauth2.service.TbUserService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:24
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private DataSource dataSource;
    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.selectOne(new LambdaQueryWrapper<TbUser>().eq(TbUser::getUsername,username).last("limit 1"));
    }

    @Override
    public TbUser getuserbyID() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tb_user");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
