package com.mmall.concurrency.example.singleton;

/**
 * Created by chao on 2018/9/11.
 */

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * synchronized使线程安全，但会造成性能开销
 */

@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {}

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // 单例对象
    // volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法
    private static SingletonExample5 getInstance() {
        if (instance == null) {  // 双重检测机制
            synchronized (SingletonExample5.class) {  // 同步锁
                if (instance == null)
                    instance = new SingletonExample5();
            }
        }
        return instance;
    }
}
