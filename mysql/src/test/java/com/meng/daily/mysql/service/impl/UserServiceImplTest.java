package com.meng.daily.mysql.service.impl;

import com.meng.daily.mysql.entity.UserDo;
import com.meng.daily.mysql.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO  UserServiceImplTest
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 19:42
 */
@SpringBootTest
class UserServiceImplTest {

    @Test
    public void sort(){
        UserDo userDo2 = UserDo.builder().first(1).second(1).thrid(2).build();
        UserDo userDo4 = UserDo.builder().first(1).second(2).thrid(3).build();
        UserDo userDo3 = UserDo.builder().first(1).second(2).thrid(1).build();
        UserDo userDo9 = UserDo.builder().first(3).second(1).thrid(1).build();
        UserDo userDo10 = UserDo.builder().first(3).second(2).thrid(1).build();
        UserDo userDo1 = UserDo.builder().first(1).second(1).thrid(1).build();
        UserDo userDo6 = UserDo.builder().first(2).second(2).thrid(1).build();
        UserDo userDo5 = UserDo.builder().first(2).second(1).thrid(1).build();
        UserDo userDo8 = UserDo.builder().first(2).second(2).thrid(2).build();
        UserDo userDo7 = UserDo.builder().first(2).second(2).thrid(3).build();
        Set<UserDo> userDoSet = new TreeSet<UserDo>(new Comparator<UserDo>() {
            @Override
            public int compare(UserDo userDo, UserDo t1) {
                if(userDo.getFirst()-t1.getFirst()==0){
                    if(userDo.getSecond()-t1.getSecond()==0){
                        return userDo.getThrid()-t1.getThrid();
                    }
                    return userDo.getSecond()-t1.getSecond();
                }
                return userDo.getFirst()-t1.getFirst();
            }
        });
        userDoSet.add(userDo1);
        userDoSet.add(userDo2);
        userDoSet.add(userDo3);
        userDoSet.add(userDo4);
        userDoSet.add(userDo5);
        userDoSet.add(userDo6);
        userDoSet.add(userDo7);
        userDoSet.add(userDo8);
        userDoSet.add(userDo9);
        userDoSet.add(userDo10);
        userDoSet.forEach(d->{
            System.out.println(d.toString());
        });
    }
}