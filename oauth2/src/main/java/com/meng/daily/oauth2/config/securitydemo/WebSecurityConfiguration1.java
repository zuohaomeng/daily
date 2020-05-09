package com.meng.daily.oauth2.config.securitydemo;

import com.meng.daily.oauth2.authentication.SecurityAuthenticationFailureHandler;
import com.meng.daily.oauth2.authentication.SecurityAuthenticationSuccessHandler;
import com.meng.daily.oauth2.filter.VerificationCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: TODO    服务器安全配置
 * @Author: Hao.Zuo
 * @Date: 2020/1/4 16:02
 */
@Configuration
@EnableWebSecurity
//全局方法拦截
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//登陆配置
public class WebSecurityConfiguration1 extends WebSecurityConfigurerAdapter {

    //必须使用加密
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //资源授权配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER");
    }

    //页面配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //使用ANT模式匹配路径，账号有相应角色才可以访问
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .antMatchers("/api/user/**").hasRole("USER")
                .and()
                .authorizeRequests()//通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
                .anyRequest().authenticated()//所有请求必须登陆后访问
                .and().formLogin()
                .failureHandler(new SecurityAuthenticationFailureHandler())//失败跳转逻辑
                .successHandler(new SecurityAuthenticationSuccessHandler())//成功跳转逻辑
                .loginPage("/mylogin.html")
                //指定处理登录的请求路径
                .loginProcessingUrl("/login")
                .permitAll();

        // 将过滤器添加在UsernamePasswordAuthenticationFilter之前
        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
