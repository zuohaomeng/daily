package com.meng.daily.mysql.controller;

import com.meng.daily.mysql.entity.UserDo;
import com.meng.daily.mysql.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/18 16:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/insert")
    @ApiOperation("添加会员")
    public void insert(){
        userService.insertUser(null);
        return ;
    }
    @GetMapping("/get")
    @ApiOperation("根据id查询")
    public UserDo get(Integer userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/updateById")
    @ApiOperation("根据id修改")
    public Integer updateById(Integer userId){
        return userService.update(userId);
    }
    @GetMapping("/deleteById")
    @ApiOperation("删除")
    public Integer deleteById(Integer userId){
        return userService.delete(userId);
    }
}