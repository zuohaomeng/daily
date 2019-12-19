package com.meng.daily.mysql.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.daily.mysql.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 17:04
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDo> {
    @Select("select count(*) from user")
    int count();
    @Select("select * from user ${ew.customSqlSegment}")
    List<UserDo> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);
}
