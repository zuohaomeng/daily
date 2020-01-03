package com.meng.daily.oauth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:05
 */
@Data
@TableName("tb_permission")
public class TbPermission implements Serializable {

    private static final long serialVersionUID = -3214283749305260650L;
    private Long id;
    /**
     * 父权限
     */
    private Long parentId;
    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限英文名称
     */
    private String enname;

    /**
     * 备注
     */
    private String description;

    private Date created;

    private Date updated;

}
