package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 统计当前线程执行时间<br>
 * 来自《Java并发编程的艺术》
 *
 * @author moon-zhou
 * @date 2020/6/11 09:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            System.out.println("init value...");
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        System.out.println("begin...");
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        System.out.println("end...");
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        testMainThread();

        testMultiThread();
    }

    /**
     * 测试主线程里的计时功能
     * @throws InterruptedException
     */
    private static void testMainThread() throws InterruptedException {
        Demo001Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " Cost: " + Demo001Profiler.end() + " miles");
    }

    private static void testMultiThread() {

        new Thread(() -> {
            Demo001Profiler.begin();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Cost: " + Demo001Profiler.end() + " miles");
        }, "thread-001").start();

        new Thread(() -> {
            Demo001Profiler.begin();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Cost: " + Demo001Profiler.end() + " miles");
        }, "thread-002").start();
    }
}
