package com.meng.daily.dubboproducer.service.impl;

import com.meng.daily.dubbointerface.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 17:19
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void helloDubbo() {
        System.out.println("hello dubbo");
    }
}
