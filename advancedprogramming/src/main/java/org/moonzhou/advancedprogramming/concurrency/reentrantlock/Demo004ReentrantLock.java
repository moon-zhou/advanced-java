package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock示例<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/28 19:07
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004ReentrantLock {
    private static Lock lock = new ReentrantLock(); // 重入锁
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(100);
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

    // 通过ReentrantLock保证线程之间的同步
    private static void add() {
        lock.lock();
        count++;
        lock.unlock();
    }
}
