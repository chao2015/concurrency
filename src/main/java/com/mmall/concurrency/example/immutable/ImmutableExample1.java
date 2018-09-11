package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by chao on 2018/9/11.
 *
 * final
 */

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    private void test(final int a) {
//        a = 1;
    }

    public static void main(String[] args) {
//        a = 2;  // final修饰的基本数据类型，不能修改
//        b = "3";
//        map = Maps.newHashMap();  // final修饰的引用，不能指向另外的对象
        map.put(1, 3);  // final修饰的引用，但是其值可以修改
        log.info("{}", map.get(1));
    }
}
