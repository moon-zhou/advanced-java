package org.moonzhou.advancedprogramming.concurrency.condition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过Lock-Condition，实现线程的串行执行
 */
public class Demo001 {
    // 信号量
    AtomicInteger ticket = new AtomicInteger(1);
    public Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Condition[] conditions = {condition1, condition2, condition3};

    public void foo(int name) {
        try {
            lock.lock();
            // 因为线程的执行顺序是不可预期的，因此需要每个线程自旋
            System.out.println("线程" + name + " 开始执行");
            if (ticket.get() != name) {
                try {
                    System.out.println("当前标识位为" + ticket.get() + ",线程" + name + " 开始等待");
                    // 开始等待被唤醒
                    conditions[name - 1].await();
                    System.out.println("线程" + name + " 被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name);
            ticket.getAndIncrement();
            if (ticket.get() > 3) {
                ticket.set(1);
            }
            // 执行完毕，唤醒下一次。1唤醒2,2唤醒3
            conditions[name % 3].signal();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Demo001 example = new Demo001();
        Thread t1 = new Thread(() -> {
            example.foo(1);
        });
        Thread t2 = new Thread(() -> {
            example.foo(2);
        });
        Thread t3 = new Thread(() -> {
            example.foo(3);
        });

        // 可以调整顺序来复现2或3先执行的情况，1-2-3本身很容易就是按顺序执行
        t1.start();
        t2.start();
        t3.start();
    }
}

