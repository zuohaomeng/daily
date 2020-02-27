package com.meng.daily.basejava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BasejavaApplication {

    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0;i<100;i++){
                log.info("---test---"+i);
            }
        }).start();
        SpringApplication.run(BasejavaApplication.class, args);
    }

}
