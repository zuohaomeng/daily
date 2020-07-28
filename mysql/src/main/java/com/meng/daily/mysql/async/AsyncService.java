package com.meng.daily.mysql.async;

import com.meng.daily.common.compose.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-07-28 11:13
 */
@Async
@Service
public class AsyncService {

    public Future<Boolean> asyncSleep() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        return AsyncResult.forValue(true);
    }

    @Async
    public Object async() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        return Boolean.TRUE;
    }
    @Async
    public Future<Boolean> asyncSort(){
        int LENGTH = 1000000;
        List<User> userList = new ArrayList();
        Random random = new Random(47);
        for (int i = 0; i < LENGTH; i++) {
            int k = random.nextInt(LENGTH);
            userList.add(new User(String.valueOf(k), k));
        }
        //stream
        long start1 = System.currentTimeMillis();
        List<User> list1 = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("stream:" + (System.currentTimeMillis() - start1));
        //并行
        long start2 = System.currentTimeMillis();
        List<User> list2 = userList.parallelStream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("parallelStream:" + (System.currentTimeMillis() - start2));
        //sort
        long start3 = System.currentTimeMillis();
        userList.sort(Comparator.comparing(User::getAge));
        System.out.println("sort:" + (System.currentTimeMillis() - start3));
        if(1==1){
            throw new RuntimeException();
        }
        return AsyncResult.forValue(true);

    }
}
