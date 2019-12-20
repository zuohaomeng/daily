package com.meng.daily.mysql.controller;

import com.meng.daily.mysql.service.TxService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO   事物管理
 * @Author: Hao.Zuo
 * @Date: 2019/12/20 11:24
 */
@RestController
@RequestMapping("/tx")
public class TxController {
    @Resource
    private TxService txService;
    @RequestMapping("/insertTx")
    @ApiOperation("插入多条数据事物")
    public Object insertTx(int error){
        txService.insertTx(error);
        return "OK";
    }
}
