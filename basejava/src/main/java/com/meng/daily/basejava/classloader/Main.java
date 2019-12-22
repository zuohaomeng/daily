package com.meng.daily.basejava.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/22 19:37
 */
public class Main {
    /**
     * 执行自定义类加载器
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String realPath = Main.class.getResource("").getPath();
        String path = realPath.substring(1) + "User.class";
        System.out.println(path);
        MyClassLoader myClassLoader = new MyClassLoader(path);
        String className = "com.meng.daily.basejava.classloader.User";
        Class<?> User = myClassLoader.findClass(className);

        System.out.println("类加载器是:" + User.getClassLoader());

        //利用反射获取main方法
        Method method = User.getDeclaredMethod("hello");
        Object object = User.newInstance();
        method.invoke(object);


    }
}
