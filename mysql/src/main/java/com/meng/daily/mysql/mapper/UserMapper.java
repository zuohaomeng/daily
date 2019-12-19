package com.meng.daily.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meng.daily.mysql.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 17:04
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDo> {
}
