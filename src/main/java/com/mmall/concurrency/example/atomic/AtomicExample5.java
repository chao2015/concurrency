package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chao on 2018/9/10.
 *
 * AtomicIntegerFieldUpdater类
 */

@Slf4j
@ThreadSafe 
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
    // fieldName必须是volatile并且非static字段

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
