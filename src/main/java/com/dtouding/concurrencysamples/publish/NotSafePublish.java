package com.dtouding.concurrencysamples.publish;

import com.dtouding.concurrencysamples.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 不安全的 对象发布
 * values对象可以被其他线程直接篡改，从而导致现成不安全性
 */
@Slf4j
@NotThreadSafe
public class NotSafePublish {

    private String[] values = {"a", "b", "c"};

    public String[] getValues() {
        return values;
    }

    public static void main(String[] args) {
        NotSafePublish publish = new NotSafePublish();
        log.info("{}", Arrays.toString(publish.getValues()));
        publish.getValues()[0] = "d";
        log.info("{}", Arrays.toString(publish.getValues()));
    }
}
