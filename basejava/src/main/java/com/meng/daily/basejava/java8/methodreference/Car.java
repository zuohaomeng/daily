package com.meng.daily.basejava.java8.methodreference;

import lombok.Data;

import java.util.function.Supplier;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/5 11:21
 */
@Data
public class Car {

    private int No;
    static int i = 0;
    public Car(){
        No = i++;
    }

    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }


}
