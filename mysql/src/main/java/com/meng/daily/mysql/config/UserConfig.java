package com.meng.daily.mysql.config;

import com.meng.daily.mysql.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/22 16:55
 */
@Configuration
public class UserConfig {
    @Bean
    public User user(){
        return new User();
    }
}
