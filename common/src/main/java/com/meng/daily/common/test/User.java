package com.meng.daily.common.test;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 17:01
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2237055164353171085L;
    /**
     * 数据库自动添加
     */
    private Integer userid;
    private String name;
    private String email;
    private Integer sex;
    private Date updateTime;
}
