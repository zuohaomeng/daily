package com.meng.daily.dubboconsumer.service.impl;

import com.meng.daily.dubboconsumer.service.UserService;
import com.meng.daily.dubbointerface.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 19:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Reference
    private HelloService helloService;
    public void sayHelloService(){
        helloService.helloDubbo();
    }
}
