package com.dtouding.concurrencysamples.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

/**
 * Google Guava包中提供了不可变结合类
 */
@Slf4j
public class GuavaImmutable {
    /**
     * update会抛出异常
     */
    public static void testImmutableMap() {
        ImmutableMap map = ImmutableMap.of(1, "a",
                2, "b",
                3, "c");
        map.put(4, "d");
    }

    /**
     * add元素会抛出异常
     */
    public static void testImmutableList() {
        ImmutableList list = ImmutableList.of(1, 2, 3, 4);
        list.add(5);
    }

    public static void main(String[] args) {
        testImmutableMap();
    }
}
