package com.meng.daily.basejava.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 梦醉
 * @date 2019/12/31--21:48
 */
public class Cache {
    private Map<Integer, Integer> map;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock r = lock.readLock();
    private Lock w = lock.writeLock();

    public Cache(int size) {
        //类似热加载
        map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
    }
    //锁升级
    int get(int k) {
        w.lock();
        Integer v;
        try {
            v = map.get(k);
            if (v == null) {
                r.lock();
                try {
                    map.put(k, k);
                } finally {
                    r.unlock();
                }
            }
            v = map.get(k);
        } finally {
            w.unlock();
        }
        return v;
    }

    void remove(int k) {
        r.lock();
        try {
            System.out.println(map.remove(k));
        } finally {
            r.unlock();
        }
    }

    void add(int k) {
        w.lock();
        try {
            map.put(k, k);
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        Cache cache = new Cache(10);
        cache.get(1111);
    }
}
