package com.meng.daily.basejava.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/4 21:08
 */
public class ArraysDemo {
    public static void main(String[] args) {

        //正确的写法
        Arrays.asList("a", "b", "c").forEach(a -> System.out.println(a));

        //也可以
        List<Integer> list1 = create();
        list1.forEach((a) -> System.out.println(a));

        //错误的写法，不能用
        int[] list = {1, 2, 3, 4, 5};
        System.out.println("错误的写法-----");
        Arrays.asList(list).forEach(a -> System.out.println(a));

        sort();

    }

    public static List<Integer> create() {
        List list1 = new ArrayList();
        list1.add(3);
        list1.add(5);
        list1.add(1);
        list1.add(4);
        list1.add(2);
        return list1;
    }

    public static void sort() {
        System.out.println("-----sort-----");
        List<Integer> list = create();
        list.sort((a,b)->a.compareTo(b));
        list.forEach(a -> System.out.println(a));
    }
}
