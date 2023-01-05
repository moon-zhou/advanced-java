package org.moonzhou.advancedprogramming.concurrency.cas.demo002unsafecas;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

/**
 * CAS, 全称Compare And Swap。CAS 的底层是 lock cmpxchg 指令（X86 架构），在单核 CPU 和多核 CPU 下都能够保证【比较-交换】的原子性。
 * CAS 必须借助 volatile 才能读取到共享变量的最新值来实现【比较并交换】的效果，volatile特性为保障线程之间的可见性，但不是线程安全。
 * CAS 和 volatile 可以实现无锁并发，适用于线程数少、多核 CPU 的场景或者读多写少的场景【核心为无锁并发/无阻塞并发】。如果是写多的场景，也可能会导致竞争激烈，频繁重试。所以合适的场景选择合适的方案，才是最重要的。
 *
 * @author moon zhou
 * @version 1.0
 * @description: customized cas implementation demo
 * @date 2023/1/5 09:33
 */
@Getter
@Slf4j
public class AccountCAS {

    // 余额（此处为了实现CAS的方法，使用了基本数据类型且添加了变量在不同线程的内存可见字段volatile，实际开发过程中，可以直接使用JDK已经实现类型：AtomicInteger）
    private volatile int balance;

    static final Unsafe unsafe;
    static final long BALANCE_OFFSET;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            // balance 属性在 AccountCAS 对象中的偏移量，用于 Unsafe 直接访问该属性
            BALANCE_OFFSET = unsafe.objectFieldOffset(AccountCAS.class.getDeclaredField("balance"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public AccountCAS(int balance) {
        this.balance = balance;
    }

    /**
     * 模拟账户取钱，使用CAS自旋的设计思想进行实现
     * @param amount
     */
    public void withDraw(Integer amount) {
        while (true) {
            int oldBalance = balance;
            int newBalance = oldBalance - amount;

            // 更新余额，BALANCE_OFFSET表示balance属性的偏移量， 返回true表示更新成功， false更新失败，重新进入循环尝试继续更新
            if (unsafe.compareAndSwapInt(this, BALANCE_OFFSET, oldBalance, newBalance)) {
                return;
            }
        }
    }

    /**
     * 为方便统计耗时，使用多线程模拟并发的时候，主线程统计必须要在所有子线程均执行完成之后，此处使用的是CountDownLatch方案。
     * 其他的主线程需要等待子线程执行完之后再执行的方案还有join、CyclicBarrier
     * @param args
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1000);

        // 初始化用户，余额10000
        AccountCAS account = new AccountCAS(10000);

        long start = System.nanoTime();

        // 1000个线程，每次取10元
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                account.withDraw(10);

                // 表示此线程执行完成
                latch.countDown();
            }).start();
        }

        try {
            // 阻塞等待子线程都执行完成，方便统计执行耗时，当值为0时，阻塞解除，继续往下执行
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.nanoTime();

        // 打印账户余额和花费时间
        log.info("账户余额：{}, 花费时间: {}", account.getBalance(), (end-start)/1000_000 + " ms");


        // 如下为使用join进行主线程子线程同步方案
        // 账户10000元
        /*AccountCAS account = new AccountCAS(10000);
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        // 1000个线程，每次取10元
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        // 打印账户余额和花费时间
        log.info("账户余额：{}, 花费时间: {}", account.getBalance(), (end-start)/1000_000 + " ms");*/

    }
}
