package com.meng.daily.rocketmq.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梦醉
 * @date 2019/11/24--14:14
 */
@Slf4j
@RestController()
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hi")
    public Object helloWorld() {
        log.info("helloworld");
        return "hello world";
    }
    @GetMapping("/log")
    public String log(){
        log.debug("debug");
        log.info("log");
        log.warn("warn");
        log.error("error");
        log.trace("trace");
        return "测试输出级别";
    }
}
