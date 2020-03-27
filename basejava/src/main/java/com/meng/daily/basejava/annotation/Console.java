package com.meng.daily.basejava.annotation;


import org.springframework.web.bind.annotation.RequestParam;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author HAO.ZUO
 * @date 2020/3/27--0:20
 */


public class Console {
    public static void main(@RequestParam String[] args) throws NoSuchFieldException, NoSuchMethodException {
        System.out.print("获取类上面的所有注解：");
        Annotation[] annotations = Businessman.class.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].annotationType());
        }

        Class<Businessman> clazz = Businessman.class;
        System.out.println("判断类上的是否注解："+clazz.isAnnotationPresent(Apple.class));

        Field name = clazz.getField("Name");
        System.out.println("判断属性上的是否注解："+name.isAnnotationPresent(Fruits.class));

        Method sell = clazz.getMethod("sell");
        System.out.println("判断方法上的是否注解："+sell.isAnnotationPresent(Fruits.class));

        boolean hasAnnotation = clazz.isAnnotationPresent(Apple.class);
        if(hasAnnotation){
            Apple annotation = clazz.getAnnotation(Apple.class);
            System.out.println("注解上面的值："+annotation.price());
        }
    }
}
