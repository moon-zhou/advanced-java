package org.moonzhou.advancedprogramming.reentrantlock;

/**
 * synchronized支持重入demo<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/27 20:03
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002SynchronizedReentrantLock {
    public synchronized void get() {
        System.out.println("method:get  threadName:" + Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println("method:set  threadName:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Demo002SynchronizedReentrantLock test = new Demo002SynchronizedReentrantLock();

        while (true) {
            new Thread(()->{
                test.get();
            }).start();
        }
    }
}
