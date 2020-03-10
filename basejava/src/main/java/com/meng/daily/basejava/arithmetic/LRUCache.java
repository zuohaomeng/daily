package com.meng.daily.basejava.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 梦醉
 * @date 2020/3/2--18:12
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
    HashMap map = null;
    LinkedList list = null;
    int size=0;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap();
        list = new LinkedList();
    }

    public int get(int key) {
        Object value =  map.get(key);
        if(value!=null){
            list.remove((Object) key);
            list.add(key);
            return (int) value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.size()>= size){
            if(map.containsKey(key)){
                map.remove((Object)key);
                list.remove((Object)key);
            }else {
                Object o = list.removeFirst();
                map.remove((Object)o);
            }
            map.put(key, value);
            list.add(key);
        }else {
            if(map.containsKey(key)){
                map.remove((Object)key);
                list.remove((Object)key);
            }
            map.put(key, value);
            list.add(key);
        }
    }
}
