package com.meng.daily.oauth2.config;

import com.google.common.collect.Lists;
import com.meng.daily.oauth2.entity.TbPermission;
import com.meng.daily.oauth2.entity.TbUser;
import com.meng.daily.oauth2.mapper.TbUserMapper;
import com.meng.daily.oauth2.service.TbPermissionService;
import com.meng.daily.oauth2.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO 自定义用户认证与授权
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:22
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private TbUserService tbUserService;
    @Resource
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(userName);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());

            // 声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if (tbPermission != null && tbPermission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
