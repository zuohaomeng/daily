package com.meng.spbnodependence.controller;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-04 14:45
 */
@Slf4j
@RestController
@RequestMapping("/threadpool")
public class ThreadPoolController {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
            5, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactoryBuilder().setNamePrefix("myThread-").build(),
            new ThreadPoolExecutor.AbortPolicy());
    @GetMapping("create")
    public String createThreadPool(){
        IntStream.range(0, 10)
                .forEach(i->{
                    executor.execute(()->{
                      log.info("线程信息：{}", Thread.currentThread().getName());
                    });
                });


        return "success";
    }
}
