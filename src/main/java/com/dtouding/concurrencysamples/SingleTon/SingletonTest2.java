package com.dtouding.concurrencysamples.SingleTon;

import com.dtouding.concurrencysamples.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式 - 类装载时生成实例
 */
@Slf4j
@ThreadSafe
public class SingletonTest2 {
    /**
     * 构造函数私有化
     */
    private SingletonTest2() {

    }

    /**
     * 单例对象
     */
    private static SingletonTest2 instance = new SingletonTest2();

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonTest2 getInstance() {
        return instance;
    }
}
