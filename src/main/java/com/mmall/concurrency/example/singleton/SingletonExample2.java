package com.mmall.concurrency.example.singleton;

/**
 * Created by chao on 2018/9/11.
 */

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 适用情况：构造函数比较简单，类装载后确定会使用，否则类装载较慢，造成性能问题
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {}

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    private static SingletonExample2 getInstance() {
        return instance;
    }
}
