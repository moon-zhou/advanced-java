package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock尝试获取锁<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/19 11:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo008ReentrantLockTry implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock success");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println("unlock success");
            } else {
                System.out.println("no lock.");
            }
        }
    }

    public static void main(String[] args) {
        Demo008ReentrantLockTry tryLockTest = new Demo008ReentrantLockTry();
        Thread thread1 = new Thread(tryLockTest);
        Thread thread2 = new Thread(tryLockTest);
        thread1.start();
        thread2.start();
    }

}
