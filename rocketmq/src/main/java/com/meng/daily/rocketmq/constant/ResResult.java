package com.meng.daily.rocketmq.constant;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/11/28 16:17
 */
@Data
public class ResResult {
    public int code;
    public String message;
    Object data;
    private ResResult(){}
    public static ResResult success(Object result){
        ResResult resResult = new ResResult();
        resResult.setCode(200);
        resResult.setMessage("成功");
        resResult.setData(result);
        return resResult;
    }
    public static ResResult success(){
        ResResult resResult = new ResResult();
        resResult.setCode(200);
        resResult.setMessage("成功");
        return resResult;
    }
    public static ResResult error(){
        ResResult resResult = new ResResult();
        resResult.setCode(500);
        resResult.setMessage("失败");
        return resResult;
    }
}
