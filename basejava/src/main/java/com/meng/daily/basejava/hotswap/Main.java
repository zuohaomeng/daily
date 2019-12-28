package com.meng.daily.basejava.hotswap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/23 13:51
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String realPath = com.meng.daily.basejava.classloader.Main.class.getResource("").getPath();
        String path = realPath.substring(1) + "User.class";
        URL url = new URL("file:E:\\hotswap.jar");

        URLClassLoader classloader = null;

        while (true) {
            Thread.sleep(1000);
            classloader = new URLClassLoader(new URL[]{url});
            Class clazz = Class.forName("com.meng.classloader.clazz.User", true, classloader);
            System.out.println(clazz.getClassLoader());
            Method method = clazz.getMethod("hello");
            method.invoke(clazz.newInstance());
        }
    }
}
