package com.meng.daily.mysql.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.meng.daily.mysql.entity.UserDo;
import com.meng.daily.mysql.mapper.UserMapper;
import com.meng.daily.mysql.service.TxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/20 11:27
 */
@Service
public class TxServiceImpl implements TxService {
    @Resource
    private UserMapper userMapper;
    @Override
    @Transient
    public Object insertTx(int error) {
        Random random = new Random();
        UserDo user1 = UserDo.builder().email(random.nextInt(1000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user2 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user3 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user4 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user5 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();
        UserDo user6 = UserDo.builder().email(random.nextInt(10000000)+"@qq.com").name("王三").sex(1).build();

        userMapper.insert(user1);
        userMapper.insert(user2);
        userMapper.insert(user3);
        if(error==1){
            throw new RuntimeException("看看是否有异常回归");
        }
        userMapper.insert(user4);
        userMapper.insert(user5);
        userMapper.insert(user6);

        return null;
    }
}
