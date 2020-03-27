package com.meng.daily.basejava.annotation;

import java.lang.annotation.*;

/**
 * @author HAO.ZUO
 * @date 2020/3/27--19:32
 */
@Repeatable(value = Fruits.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Apple {
    double price();
}
