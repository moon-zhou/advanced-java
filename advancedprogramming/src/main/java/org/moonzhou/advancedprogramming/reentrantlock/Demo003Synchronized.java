package org.moonzhou.advancedprogramming.reentrantlock;

import java.util.concurrent.CountDownLatch;

/**
 * synchronized示例<br>
 *
 * @author moon-zhou
 * @date: 2020/4/28 19:04
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003Synchronized {
    private static final Object lock = new Object(); // 定义锁对象
    private static int count = 0; // 累加数

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(100);
        // 启动100个线程对count累加，每个线程累加1000000次
        // 调用add函数累加，通过synchronized保证多线程之间的同步
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000000; i1++) {
                    add();
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("Time cost: " + (System.currentTimeMillis() - start) + ", count = " + count);
    }

    private static void add() {
        synchronized (lock) {
            count++;
        }
    }
}
