package com.meng.daily.rocketmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class RocketmqApplicationTests {

    @Test
    void contextLoads() {
        Random random = new Random(49);
    }

}
