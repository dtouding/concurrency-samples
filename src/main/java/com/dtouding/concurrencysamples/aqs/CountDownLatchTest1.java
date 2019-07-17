package com.dtouding.concurrencysamples.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchTest1 {

    private final static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i=0; i<threadTotal; i++) {
            final int num = i;
            executorService.submit(() ->{
                try {
                    test(num);
                } catch (Exception e) {
                    log.error("", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        ///countDownLatch.await();
        countDownLatch.await(1, TimeUnit.SECONDS);
        log.info("finish.");
        executorService.shutdown();
    }

    static void test(int i) throws Exception {
        Thread.sleep(1000);
        log.info("Thread - {}", i);
    }
}
