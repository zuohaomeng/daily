package com.meng.daily.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.daily.oauth2.entity.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2020/1/3 16:05
 */
@Mapper
public interface TbPermissionMapper extends BaseMapper<TbPermission> {

    @Select("SELECT " +
            "p.* " +
            "FROM " +
            "tb_user AS u " +
            "LEFT JOIN tb_user_role AS ur ON u.id = ur.user_id " +
            "LEFT JOIN tb_role AS r ON r.id = ur.role_id " +
            "LEFT JOIN tb_role_permission AS rp ON r.id = rp.role_id " +
            "LEFT JOIN tb_permission AS p ON p.id = rp.permission_id " +
            "WHERE " +
            "u.id = #{userId}")
    List<TbPermission> selectByUserId(Long userId);
}
