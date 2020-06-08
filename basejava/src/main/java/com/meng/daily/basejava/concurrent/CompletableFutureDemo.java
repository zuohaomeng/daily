package com.meng.daily.basejava.concurrent;

import java.util.concurrent.*;

/**
 * @author 梦醉
 * @date 2020/1/1--19:01
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testAND();
    }
    //加没加Async代表是否异步执行。
    public static void testAND() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("运行了1");
        },Executors.newFixedThreadPool(3));
        CompletableFuture<Void> future1 = future.thenRunAsync(() -> {
            System.out.println("then1");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("then1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> future2 = future.thenRunAsync(() -> {
            System.out.println("then2");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("then2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //OR方法执行
//        future1.runAfterEither(future2, () -> {
//            System.out.println("Both3");
//        });
        //AND集合执行
        future1.runAfterBoth(future2, () -> {
            System.out.println("Both3");
        });
    }

    //串行执行
    public static void testThen() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("运行了1");
        });
        System.out.println("future:" + future.toString());

        CompletableFuture<Void> future1 = future.thenRunAsync(() -> {
            System.out.println("then1");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("then1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future1.thenRunAsync(() -> {
            System.out.println("then2");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("then2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("1");
    }

}
