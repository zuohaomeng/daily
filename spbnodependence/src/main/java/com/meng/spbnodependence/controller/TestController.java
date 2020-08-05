package com.meng.spbnodependence.controller;

import com.meng.spbnodependence.component.OrderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-04 17:22
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/get")
    public String get(@RequestParam Integer status) {
        Integer price = 1000;
        Integer price2 = 1000;

        int t = 100;
        System.out.println(price == price2);
        System.out.println(price == t);
        OrderEnum e = OrderEnum.IPHONE;
        System.out.println(status == e.getStatus());
        return "success";
    }

    public static void main(String[] args) {
//        System.out.println(0.1 + 0.2);
//        System.out.println(1.0 - 0.8);
//        System.out.println(4.015 * 100);
//        System.out.println(123.3 / 100);
//        double amount1 = 2.15;
//        double amount2 = 1.10;
//        if (amount1 - amount2 == 1.05) {
//            System.out.println("OK");
//        }

    }
}

