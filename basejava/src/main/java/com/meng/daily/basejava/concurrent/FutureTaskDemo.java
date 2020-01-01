package com.meng.daily.basejava.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 梦醉
 * @date 2020/1/1--18:25
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(()->{
            System.out.println("运行了");
            return 1;
        });
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
