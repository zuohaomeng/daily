package com.meng.daily.basejava.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description:    自定义类加载器
 * @Author: Hao.Zuo
 * @Date: 2019/12/22 19:27
 */
public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }
    public MyClassLoader(){

    }
    /**
     * 重写findClass方法
     *
     * @param name 是我们这个类的全路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        Class c = findLoadedClass(name);
        System.out.println("当前类是否被加载:" + ((c == null) ? "没有" : "加载"));
        // 获取该class文件字节码数组
        byte[] classData = getData();

        // 将class的字节码数组转换成Class类的实例
        clazz = defineClass(name, classData, 0, classData.length);
        return clazz;
    }


    /**
     * 将class文件转化为字节码数组
     *
     * @return
     */
    private byte[] getData() {

        File file = new File(path);
        if (file.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        } else {
            return null;
        }


    }


}
