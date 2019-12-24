package com.meng.daily.basejava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BasejavaApplicationTests {

    @Test
    void contextLoads() {
        Date date = new Date(1577116800000L);
        System.out.println((date.getTime()-System.currentTimeMillis())/1000/60/60);
        System.out.println(date);
    }

}
