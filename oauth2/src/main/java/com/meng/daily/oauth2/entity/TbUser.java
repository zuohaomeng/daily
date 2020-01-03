package com.meng.daily.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO  用户
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:12
 */
@Data
@TableName("tb_user")
public class TbUser implements Serializable {
    private static final long serialVersionUID = -8172356428430207929L;

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    private Date created;

    private Date updated;
}
