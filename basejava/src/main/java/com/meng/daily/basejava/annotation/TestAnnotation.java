package com.meng.daily.basejava.annotation;

import java.lang.annotation.*;

/**
 * @author HAO.ZUO
 * @date 2020/3/27--0:19
 */
@Inherited
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String type() default "";
}
