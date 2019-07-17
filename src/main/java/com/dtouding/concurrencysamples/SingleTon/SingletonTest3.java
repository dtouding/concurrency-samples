package com.dtouding.concurrencysamples.SingleTon;

import com.dtouding.concurrencysamples.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式 - 第一次使用时生成实例
 * 双重同步锁，单例模式
 * 只是在实例未生成时影响性能，后续无影响
 * 但是由于cpu指令重排序的缘故，会导致线程不安全
 * 实例化对象过程：
 * 1 分配对象的内存空间
 * 2 初始化实例对象
 * 3 instance指向刚分配的内存
 */
@Slf4j
@NotThreadSafe
public class SingletonTest3 {

    /**
     * 构造函数私有化
     */
    private SingletonTest3() {

    }

    /**
     * 单例对象
     */
    private static SingletonTest3 instance = null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonTest3 getInstance() {
        if (null == instance) {
            synchronized (SingletonTest3.class) {
                if (instance == null) {
                    return new SingletonTest3();
                }
            }

        }
        return instance;
    }


}
