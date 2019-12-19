package com.meng.daily.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 17:01
 */
@TableName("User")
@Data
@Builder
public class UserDo implements Serializable {
    private static final long serialVersionUID = -2237055164353171085L;
    /**
     * 数据库自动添加
     */
    @TableId(type = IdType.AUTO)
    private Integer userid;
    private String name;
    private String email;
    private Integer sex;
    private Date updateTime;
}
