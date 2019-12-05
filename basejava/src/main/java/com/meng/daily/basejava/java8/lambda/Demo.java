package com.meng.daily.basejava.java8.lambda;

/**
 * @Description: TODO   lambda表达式使用
 * @Author: Hao.Zuo
 * @Date: 2019/12/4 16:11
 */
public class Demo {
    int c = 22;
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.operation1();
        demo.printf();
        demo.anonymityOuterClass();
    }
    void anonymityOuterClass(){
        //jdk8以前才是index必须定义为final
        int d =3;
        new MathOperation() {
            @Override
            public int operation(int a, int b) {
                System.out.println("匿名内部类中的c："+c);
                System.out.println(d);
                return 0;
            }
        }.operation(1,2);
    }
    void operation1(){
        //创建一个MathOperation的临时类，在这里不进行调用
        //相当于局部内部类
        MathOperation operation1 = (int a, int b) -> {
            System.out.println(1 - 2);
            System.out.println(2 - 3);
            System.out.println("c="+c);
            return a;
        };
        MathOperation operation2 = (a, b) -> 1 + 2;

        //使用这个临时类，
        System.out.println(operation1.operation(99, 93));
        System.out.println(operation2.operation(3, 4));

    }
    /**
     * 模拟没有返回值的lambda
     */
    private  void printf() {
        GreetingService greetingService1 = (a -> {
            System.out.println(a);
        });
        GreetingService greetingService2 = b -> System.out.println(b - 1);
        greetingService1.printy(1L);
        greetingService2.printy(2L);
    }

}
