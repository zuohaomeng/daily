package com.meng.spbnodependence.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-04 10:32
 */
@Slf4j
@RestController
@RequestMapping("/count")
public class CountController {
    //线程个数
    private static int THREAD_COUNT = 10;
    //总元素数
    private static int ITEM_COUNT = 1000;
    private static int LOOP_COUNT = 10000000;

    @GetMapping("/wrongaddcount")
    public String wrongAddCount() throws InterruptedException {
        Lock lock = new ReentrantLock();
        ConcurrentHashMap concurrentHashMap = getData(ITEM_COUNT - 100);
        //初始化900
        log.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            lock.lock();
            int gap = ITEM_COUNT - concurrentHashMap.size();
            log.info("gap size:{}", gap);
            //补充元素
            concurrentHashMap.putAll(getData(gap));
            lock.unlock();
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        log.info("finish size:{}", concurrentHashMap);

        return "OK";
    }

    private ConcurrentHashMap getData(int count) {
        ConcurrentHashMap<String, Integer> collect = new Random().ints(1, 10000)
                .limit(count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(),
                        i -> i, (o1, o2) -> o1,
                        ConcurrentHashMap::new));
        return collect;
    }

    @GetMapping("/gooduse")
    public String gooduse() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);

        forkJoinPool.execute(() -> IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        Map<String, Long> collect = freqs.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue().longValue()));
        log.info("collect={}", collect);
        log.info("sum collect:{}", collect.values().stream().count());
        return String.valueOf(collect.size());
    }

    @GetMapping("/testIntStream")
    public void testIntStream(){
        IntStream.rangeClosed(1, 3).boxed().forEach(System.out::println);
    }

    public static void main(String[] args) {
    }
}
