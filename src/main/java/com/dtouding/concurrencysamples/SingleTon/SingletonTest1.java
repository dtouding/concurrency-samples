package com.dtouding.concurrencysamples.SingleTon;

import com.dtouding.concurrencysamples.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式 - 第一次使用时生成实例
 */
@Slf4j
@NotThreadSafe
public class SingletonTest1 {

    /**
     * 构造函数私有化
     */
    private SingletonTest1() {

    }

    /**
     * 单例对象
     */
    private static SingletonTest1 instance = null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonTest1 getInstance() {
        if (null == instance) {
            return new SingletonTest1();
        }
        return instance;
    }


}
