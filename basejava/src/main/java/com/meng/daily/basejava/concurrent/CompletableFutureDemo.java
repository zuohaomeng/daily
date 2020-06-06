package com.meng.daily.basejava.concurrent;

import java.util.concurrent.*;

/**
 * @author 梦醉
 * @date 2020/1/1--19:01
 */
public class CompletableFutureDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void start() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("运行了1");
        }, Executors.newFixedThreadPool(3));
        System.out.println("future:" + future.toString());
        future.thenRunAsync(() -> {
            System.out.println("then");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("then end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRunAsync(() -> {
            System.out.println("then2");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        start();
        countDownLatch.await();
        System.out.println("结束了");
    }


}
