package com.meng.daily.basejava.concurrent;


import com.meng.daily.common.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 梦醉  使用selisthore实现一个池化对象
 * @date 2019/12/31--21:07
 */
public class ObjPool {
    private List list;
    private Semaphore semaphore;

    public ObjPool(int size) {
        list = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            list.add(RandomUtils.randInt(1000));
        }
        semaphore = new Semaphore(size);
    }

    //池化对象执行的操作
    public void exec() {
        try {
            semaphore.acquire();
            System.out.println("我正努力运行中。。。。。");
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjPool pool = new ObjPool(3);
        for (int i = 0; i < 10; i++) {
            System.out.println("1");
            TimeUnit.MILLISECONDS.sleep(100);
            new Thread(new Runnable(){
                @Override
                public void run() {
                    pool.exec();
                }
            }).start();
        }
    }
}
