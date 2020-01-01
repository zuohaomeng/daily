package com.meng.daily.basejava.concurrent;

import java.util.concurrent.*;

/**
 * @author 梦醉
 * @date 2020/1/1--19:57
 */
public class CompletionServiceDemo {
    public static void select() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletionService completionService = new ExecutorCompletionService(pool);
        completionService.submit(CompletionServiceDemo::call);
        completionService.submit(CompletionServiceDemo::call);
        completionService.submit(CompletionServiceDemo::call);
        for (int i = 0; i < 3; i++) {
            System.out.println("返回值"+completionService.take().get());
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        select();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

    private static Object call() {
        try {
            System.out.println(1);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
