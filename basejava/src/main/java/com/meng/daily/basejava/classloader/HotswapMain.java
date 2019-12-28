package com.meng.daily.basejava.classloader;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/23 14:05
 */
public class HotswapMain {
    public static void main(String[] args) {
        String realPath = Main.class.getResource("").getPath();
        String path = realPath.substring(1) + "User.class";
    }
}
