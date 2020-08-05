package com.meng.spbnodependence.controller;

import com.meng.spbnodependence.component.OrderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;

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
        System.out.println(price==price2);
        System.out.println(price==t);
        OrderEnum e = OrderEnum.IPHONE;
        System.out.println(status==e.getStatus());
        return "success";
    }
}
