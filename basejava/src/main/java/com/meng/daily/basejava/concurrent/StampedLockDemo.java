package com.meng.daily.basejava.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author 梦醉  StampedLock学习实例
 * @date 2019/12/31--22:26
 */
public class StampedLockDemo {
    private StampedLock lock = new StampedLock();
    public void get() throws Exception {
        long stamp = lock.readLock();
        try {
            System.out.println("[get]  全力运行中。。。。");
            TimeUnit.SECONDS.sleep(1);
        }finally {
            lock.unlockRead(stamp);
        }
    }
    public void set() throws Exception{
        long stamp = lock.writeLock();
        try{
            System.out.println("[set]  全力运行中。。。。");
            TimeUnit.SECONDS.sleep(1);
        }finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {

    }
}
