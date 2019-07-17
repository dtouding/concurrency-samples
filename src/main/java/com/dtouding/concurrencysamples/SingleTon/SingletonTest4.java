package com.dtouding.concurrencysamples.SingleTon;

import com.dtouding.concurrencysamples.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式 - 第一次使用时生成实例
 * 双重同步锁，单例模式
 * 只是在实例未生成时影响性能，后续无影响
 * 但是由于cpu指令重排序的缘故，会导致线程不安全
 *
 * volatile：避免指令重排序
 */
@Slf4j
@ThreadSafe
public class SingletonTest4 {

    /**
     * 构造函数私有化
     */
    private SingletonTest4() {

    }

    /**
     * 单例对象
     */
    private volatile static SingletonTest4 instance = null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonTest4 getInstance() {
        if (null == instance) {
            synchronized (SingletonTest4.class) {
                if (instance == null) {
                    return new SingletonTest4();
                }
            }

        }
        return instance;
    }

}
