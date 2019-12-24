package com.meng.daily.basejava.classloader;

import java.lang.instrument.Instrumentation;
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
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String realPath = Main.class.getResource("").getPath();
        String path = realPath.substring(1) + "User.class";
        System.out.println(path);
        newClass(path);
        newClass(path);
//        hotswapClass(path);
//        hotswapClass(path);
        return;


    }

    private static void newClass(String path) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader(path);
        String className = "com.meng.daily.basejava.classloader.User";
        Class<?> Userzz = myClassLoader.findClass(className);

        System.out.println("类加载器是:" + Userzz.getClassLoader());

        //利用反射获取main方法
        Method method = Userzz.getDeclaredMethod("hello");
        Object object = (User)Userzz.newInstance();
        method.invoke(object);
    }
    private static void hotswapClass(String path){
        User user = new User();
        user.hello();
        System.out.println(user.getClass().getClassLoader());
    }
}
