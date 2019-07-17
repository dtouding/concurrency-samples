package com.dtouding.concurrencysamples.sync;

import com.dtouding.concurrencysamples.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ThreadSafe
public class SynchronizedTest2 {

    public void test1() {
        synchronized (SynchronizedTest2.class) {
            for (int i=0; i <10; i++) {
                log.info("test1: {}", i);
            }
        }
    }

    public synchronized static void test2() {
        for (int i=0; i <10; i++) {
            log.info("test2: {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedTest2 synchronizedTest1 = new SynchronizedTest2();
        SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            synchronizedTest1.test1();
        });
        executorService.submit(() -> {
            synchronizedTest2.test1();
        });
    }
}
