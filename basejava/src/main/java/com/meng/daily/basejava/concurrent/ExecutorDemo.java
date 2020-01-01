package com.meng.daily.basejava.concurrent;


import java.util.concurrent.*;

/**
 * @author 梦醉
 * @date 2020/1/1--17:54
 */
public class ExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(()->{
            System.out.println("运行了");
                return "hello world";
        });
        System.out.println(submit.get());
        System.out.println("运行结束");
        executorService.shutdown();
    }
}
