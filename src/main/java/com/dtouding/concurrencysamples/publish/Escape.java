package com.dtouding.concurrencysamples.publish;

import com.dtouding.concurrencysamples.annotations.NotRecommend;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 *
 * Escape实例对象还未完全生成，status变量就可以被其他对象访问
 */
@Slf4j
@NotRecommend
public class Escape {

    private int status = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        InnerClass() {
            log.info("{}", Escape.this.status);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
