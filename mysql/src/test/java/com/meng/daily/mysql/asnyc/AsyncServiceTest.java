package com.meng.daily.mysql.asnyc;

import com.meng.daily.mysql.async.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-07-28 11:15
 */
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AsyncServiceTest {
    @Resource
    private AsyncService asyncService;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    public void async() throws InterruptedException, ExecutionException {
        Future<Boolean>  future= (Future<Boolean>) asyncService.asyncSleep();

        System.out.println(Thread.currentThread().getName()+"321");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.get();
        System.out.println(Thread.currentThread().getName()+"321");
        countDownLatch.await();
    }
    @Test
    public void asyncBoolean() throws ExecutionException, InterruptedException {
        Future<Boolean> future = (Future<Boolean>) asyncService.async();
        System.out.println(Thread.currentThread().getName()+"321");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(future==null) {
            System.out.println("null");
        }else {
            future.get();
        }
        System.out.println(Thread.currentThread().getName()+"321");
        countDownLatch.await();
    }
    @Test
    public void sortTest() throws ExecutionException, InterruptedException {
        Future<Boolean> future =  asyncService.asyncSort();
        System.out.println(Thread.currentThread().getName()+"321");
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(future==null) {
            System.out.println("null");
        }else {
            try {
                future.get();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
