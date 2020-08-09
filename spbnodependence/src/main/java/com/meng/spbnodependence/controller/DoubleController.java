package com.meng.spbnodependence.controller;

import com.meng.spbnodependence.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-05 14:41
 */
@Slf4j
@RestController
@RequestMapping("/double")
public class DoubleController {

    public static void main(String[] args) {
        System.out.println(2);
        //        problem2();
//        problem3();
    }

    public static void problem1() {
        Product product = new Product();
        product.setPrice(new Double(4.015));//401.5

        new BigDecimal(product.getPrice()).multiply(new BigDecimal(100)).setScale(1, BigDecimal.ROUND_DOWN);

        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));

        System.out.println(new BigDecimal("4.015").divide(BigDecimal.valueOf(100)));
        Double d = new Double(100);
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(d.toString())));


        System.out.println(new BigDecimal("1").equals(new BigDecimal("1.0")));
        System.out.println(BigDecimal.valueOf(1).equals(new BigDecimal(1.0)));
        new BigDecimal(1).equals(new BigDecimal(2));
    }

    /**
     * 测试除法
     */
    public static void problem2() {
        double i = 1;
        for (; i < 100000000; i++) {
            String t = String.format("%.2f", i);
            double d = Double.valueOf(t);
            BigDecimal falseResult = new BigDecimal(d / 365).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal trueResult = BigDecimal.valueOf(d).divide(BigDecimal.valueOf(365), 2, BigDecimal.ROUND_HALF_UP);
            if (falseResult.compareTo(trueResult) != 0) {
                System.out.println(d);
            }
        }
    }
    /**
     * 测试乘法
     */
    public static void problem3() {
        double i = 0.01;
        for (; i < 1000000; i+=0.01) {
            String t = String.format("%.2f", i);
            double d = Double.valueOf(t);
            BigDecimal falseResult = new BigDecimal(d * 365).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal trueResult = BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(365)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            System.out.println(falseResult+"\t"+trueResult);
            if (falseResult.compareTo(trueResult) != 0) {
                System.out.println(d);
            }
        }
    }
}
