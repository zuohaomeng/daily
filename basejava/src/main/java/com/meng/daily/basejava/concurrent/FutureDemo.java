package com.meng.daily.basejava.concurrent;


import java.util.concurrent.*;

/**
 * 学习使用Future
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(1);
                return null;
            }
        });
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future submit = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                int s = 1 / 0;
                System.out.println(2);
            }
        });
        System.out.println(submit.get());
        pool.shutdown();
    }
}
