package com.dtouding.concurrencysamples.CommonUnsafe;

import com.dtouding.concurrencysamples.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * StringBuilder是线程不安全的类
 */
@Slf4j
@NotThreadSafe
public class StringTest1 {

    private final static Integer clientTotal = 5000;
    private final static Integer threadTotal = 100;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0; i<clientTotal; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    append();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count: {}", sb.length());
    }

    private static void append() {
        sb.append(1);
    }
}
