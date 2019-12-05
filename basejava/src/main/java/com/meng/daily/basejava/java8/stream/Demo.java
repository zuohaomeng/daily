package com.meng.daily.basejava.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 12:48
 */
public class Demo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        stringList.stream()
                .filter((a) -> a.startsWith("a"))
                .forEach(System.out::println);
        stringList.forEach((a) -> System.out.print(a+"\t"));

        System.out.println("\nstream sort");
        stringList.stream()
                .sorted((a,b)->a.compareTo(b))
                .forEach((a) -> System.out.print(a+"\t"));

        System.out.println("\n列表排序");
        stringList.sort((a,b)->a.compareTo(b));
        stringList.forEach((a) -> System.out.print(a+"\t"));

    }
}
