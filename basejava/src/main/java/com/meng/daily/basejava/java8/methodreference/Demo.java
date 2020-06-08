package com.meng.daily.basejava.java8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO   java8方法引用
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 11:20
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println("----静态方法引用：它的语法是Class::static_method");
        Car car = Car.create(Car::new);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(new Car());

        System.out.println("-----特定类的任意对象的方法引用");
        //
        cars.forEach(Car::collide);

        System.out.println("-----特定对象的方法引用：");
        cars.forEach(Car::repair);
        System.out.println("----构造器引用：它的语法是Class::new");
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
