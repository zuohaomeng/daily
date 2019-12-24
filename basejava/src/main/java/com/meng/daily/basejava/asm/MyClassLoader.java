package com.meng.daily.basejava.asm;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/24 14:32
 */
public class MyClassLoader extends  ClassLoader{
    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }

}
