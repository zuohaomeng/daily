package com.meng.daily.basejava.designpattern;


import com.meng.daily.basejava.component.User;

import java.io.*;

/**
 * 序列化和反序列化
 */
public class SingletonDemo5 implements Serializable {
    public User user = new User();
    private static SingletonDemo5 instance = new SingletonDemo5();

    private SingletonDemo5() {
    }

    public static SingletonDemo5 getInstance() {
        return instance;
    }

    public Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }

    public static void main(String[] args) throws Exception {
        SingletonDemo5 sa = SingletonDemo5.getInstance();
        SingletonDemo5 sb = null;

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sa);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        sb = (SingletonDemo5) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("两个单例类是否相等："+(sb == sa));
    }
}
