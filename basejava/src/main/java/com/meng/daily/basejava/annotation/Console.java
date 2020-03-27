package com.meng.daily.basejava.annotation;


import java.lang.annotation.Annotation;

/**
 * @author HAO.ZUO
 * @date 2020/3/27--0:20
 */

public class Console {
    public static void main(String[] args) {
        Annotation[] annotations = Panda.class.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].toString());
        }
        //        Panda.class.getAnnotation()
    }
}
