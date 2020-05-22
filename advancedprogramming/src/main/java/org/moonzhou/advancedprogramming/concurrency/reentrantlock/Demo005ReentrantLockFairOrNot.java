package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock公平锁和非公平锁示例<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/18 14:21
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005ReentrantLockFairOrNot {
    public static void main(String[] args) {
//        testFireLock();
        testUnFireLock();
    }

    private static void testFireLock() {
        Thread t1 = new FireLock();
        Thread t2 = new FireLock();
        Thread t3 = new FireLock();
        t1.start();
        t2.start();
        t3.start();
    }

    private static void testUnFireLock() {
        Thread t1 = new UnFireLock();
        Thread t2 = new UnFireLock();
        Thread t3 = new UnFireLock();
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 公平锁示例
 * 如果是并发执行线程的方法时，就会交替执行0-1-0-1-0-1...
 */
class FireLock extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

/**
 * 非公平锁示例
 * 获取锁的线程随机，不再有规律
 */
class UnFireLock extends Thread {

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}