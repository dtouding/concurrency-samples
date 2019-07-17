package com.dtouding.concurrencysamples.sync;

import com.dtouding.concurrencysamples.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ThreadSafe
public class SynchronizedTest1 {

    public void test1() {
        synchronized (this) {
            for (int i=0; i <10; i++) {
                log.info("test1: {}", i);
            }
        }
    }

    public synchronized void test2() {
        for (int i=0; i <10; i++) {
            log.info("test2: {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            synchronizedTest1.test1();
        });
        executorService.submit(() -> {
            synchronizedTest1.test1();
        });
    }
}
