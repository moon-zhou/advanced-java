/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: Demo004ThreadLocalMemoryLeak.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/25 11:13
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:<br>
 *
 * 当localCache的值被重置之后cacheInstance被ThreadLocalMap中的value引用，无法被GC，
 * 但是其key对ThreadLocal实例的引用是一个弱引用，本来ThreadLocal的实例被localCache和ThreadLocalMap的key同时引用，
 * 但是当localCache的引用被重置之后，则ThreadLocal的实例只有ThreadLocalMap的key这样一个弱引用了，此时这个实例在GC的时候能够被清理。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004ThreadLocalMemoryLeak {
    public static void main(String[] args) {
        ThreadLocal<List<Integer>> localCache = new ThreadLocal<>();
        List<Integer> cacheInstance = new ArrayList<>(10000);
        localCache.set(cacheInstance);
        localCache = new ThreadLocal<>();

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
