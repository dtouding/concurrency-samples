package com.dtouding.concurrencysamples.CommonUnsafe;

import com.dtouding.concurrencysamples.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class DateFormatTest1 {

    private final static Integer clientTotal = 5000;
    private final static Integer threadTotal = 100;
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0; i<clientTotal; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    parse();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void parse() {
        try {
            dateFormat.parse("2019-07-14");
        } catch (ParseException e) {
            log.error("parse exception", e);
        }
    }
}
