package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

/**
 * synchronized支持重入demo<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/27 20:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001SynchronizedReentrantLock implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Demo001SynchronizedReentrantLock rt = new Demo001SynchronizedReentrantLock();
        for (; ; ) {
            new Thread(rt).start();
        }
    }
}
