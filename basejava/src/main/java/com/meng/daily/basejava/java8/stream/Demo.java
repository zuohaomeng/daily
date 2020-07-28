package com.meng.daily.basejava.java8.stream;

import com.meng.daily.basejava.component.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: https://blog.csdn.net/y_k_y/article/details/84633001
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 12:48
 */
public class Demo {
    public static List<User> list = null;

    static {
        User s1 = new User("aa", 10);
        User s2 = new User("bb", 20);
        User s3 = new User("cc", 30);
        User s4 = new User("dd", 40);
        list = Arrays.asList(s1, s2, s3, s4);
    }

    public static void main(String[] args) throws Exception {
//        测试性能
//        sortForTime();
//        Stream的静态方法
//        createStream();
//        文件读取为流
//        fileStream();
//        字符串分隔成流
//        splitToStream();
//        流的中间操作
//        筛选
//        filter();
//          映射
//        map();
//        排序
//        sorted();
//        消费
//        peek();

//        流的终止操作
//        endOperation();
//        收集操作
        collectors();
    }

    public static void collectors() {
        List<Integer> list1 = list.stream().map(User::getAge).collect(Collectors.toList());
        Set<Integer> list2 = list.stream().map(User::getAge).collect(Collectors.toSet());
        Map<String, Integer> map1 = list.stream().collect(Collectors.toMap(User::getName, User::getAge));

        //字符串分隔符连接
        String joiningName = list.stream().map(User::getName).collect(Collectors.joining(",", "(", ")"));

        //聚合操作
        //总数
        Long count = list.stream().collect(Collectors.counting());
        //最大年龄
        Integer maxAge = list.stream().map(User::getAge).collect(Collectors.maxBy(Integer::compare)).get();
        //年龄总和
        Integer sumAge = list.stream().collect(Collectors.summingInt(User::getAge));
        // 带上以上所有方法
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(User::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

        //分组
        Map<Integer, List<User>> ageMap = list.stream().collect(Collectors.groupingBy(User::getAge));
        //多重分组,先根据类型分再根据年龄分
        Map<String, Map<Integer, List<User>>> collect = list.stream().collect(Collectors.groupingBy(User::getName, Collectors.groupingBy(User::getAge)));

        //分区
        //分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<User>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));

        //规约
        Integer allAge = list.stream().map(User::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40

    }

    public static void endOperation() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list.stream().findFirst().get(); //1
        Integer findAny = list.stream().findAny().get(); //1

        long count = list.stream().count(); //5
        Integer max = list.stream().max(Integer::compareTo).get(); //5
        Integer min = list.stream().min(Integer::compareTo).get(); //1
    }


    public static void peek() {
        list.stream().peek(s -> s.setAge(100)).forEach(System.out::println);
    }

    //排序
    public static void sorted() {
        list.stream().sorted(Comparator.comparing(User::getAge).reversed().thenComparing(User::getName)).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //映射
    public static void map() {
        List<String> list = Arrays.asList("a,b,c", "1,2,3");

        //将每个元素转成一个新的且不带逗号的元素
        list.stream().map(s -> s.replaceAll(",", ""))
                .forEach(System.out::println);

        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个steam
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println);
    }

    //筛选
    public static void filter() {
        Stream<Integer> stream1 = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> stream2 = stream1.filter(s -> s > 5)
                .distinct()//去重
                .skip(3)//跳过前几个元素
                .limit(3);//只要前几个
        stream2.forEach(System.out::println);
    }

    //字符串分隔成流
    public static void splitToStream() {
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }

    //文件读取为流
    public static void fileStream() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\fileStream.txt"));
        Stream<String> lines = reader.lines();
        lines.forEach(System.out::println);

    }

    public static void createStream() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7);

        Stream<Integer> stream2 = Stream.iterate(1, (x) -> x * 2).limit(5);

        stream2.forEach((x) -> System.out.print(x + "\t"));
        System.out.println();

        Stream<Double> stream3 = Stream.generate(Math::random).limit(4);
        stream3.forEach((x) -> System.out.print(x + "\t"));
    }

    /**
     * 测试stream，parallelStream，手动的性能。
     */
    public static void sortForTime() {
        int LENGTH = 1000000;
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
