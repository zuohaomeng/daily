package com.meng.daily.basejava.java8.stream;

import com.meng.daily.basejava.component.User;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: https://www.cnblogs.com/owenma/p/12207330.html
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 12:48
 */
public class Demo {
    public static void main(String[] args) {

        sortForTime();
    }

    public static void sortForTime() {
        int LENGTH = 100;
        List<User> userList = new ArrayList();
        Random random = new Random(47);
        for (int i = 0; i < LENGTH; i++) {
            int k = random.nextInt(LENGTH);
            userList.add(new User(String.valueOf(k), k));
        }
        //stream
        long start1 = System.currentTimeMillis();
        List<User> list1 = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("stream:" + (System.currentTimeMillis() - start1));
        //并行
        long start2 = System.currentTimeMillis();
        List<User> list2 = userList.parallelStream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("parallelStream:" + (System.currentTimeMillis() - start2));
        //sort
        long start3 = System.currentTimeMillis();
        userList.sort(Comparator.comparing(User::getAge));
        System.out.println("sort:" + (System.currentTimeMillis() - start3));

    }

    public static void sort() {
        List<User> userList = new ArrayList();
        userList.add(new User("1", 3));
        userList.add(new User("2", 1));
        userList.add(new User("3", 2));
        userList.sort(Comparator.comparing(User::getAge));
//        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        userList.forEach(System.out::println);
    }

    /**
     * 使用map转化为Result格式
     */
    public static void userMapToResult() {
        List<User> userList = new ArrayList();
        userList.add(new User("1", 1));
        userList.add(new User("2", 2));
        userList.add(new User("3", 3));
        ArrayList arrayList = new ArrayList();

        //stream转化为list
        List list = userList.stream().map(User::toResult).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    public static void demo3() {
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);

        Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);
    }

    public static void demo2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10

        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }

    public static void demo1() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        System.out.println("以a开头");
        stringList.stream()
                .filter((a) -> a.startsWith("a"))
                .forEach((a) -> System.out.print("\t"));
        System.out.println("\n遍历");
        stringList.forEach((a) -> System.out.print(a + "\t"));

        System.out.println("\nstream sort");
        stringList.stream()
                .sorted((a, b) -> a.compareTo(b))
                .forEach((a) -> System.out.print(a + "\t"));

        System.out.println("\n列表排序");
        stringList.sort((a, b) -> a.compareTo(b));
        stringList.forEach((a) -> System.out.print(a + "\t"));
    }
}
