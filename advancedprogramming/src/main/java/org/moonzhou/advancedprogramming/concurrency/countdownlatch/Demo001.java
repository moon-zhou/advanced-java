package org.moonzhou.advancedprogramming.concurrency.countdownlatch;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * CountDownLatch简单使用<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/15 16:38
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {

    /**
     * 线程池创建的线程数 2*核数
     *
     * CPU密集型和IO密集型
     */
    private static int threadNum = 16;

    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程开始执行…… ……");

        // guava里的实现
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("countDownLatchDemo-pool-%d").build();

                // 第一个子线程执行
        ExecutorService es1 = new ThreadPoolExecutor(threadNum, threadNum, 10L,
                TimeUnit.SECONDS, linkedBlockingDeque, threadFactory, new ThreadPoolExecutor.AbortPolicy());
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程：" + Thread.currentThread().getName() + "执行: start...");
                    Thread.sleep(3000);
                    System.out.println("子线程：" + Thread.currentThread().getName() + "执行: end...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                latch.countDown();
            }
        });
        es1.shutdown();

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程：" + Thread.currentThread().getName() + "执行: start...");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程：" + Thread.currentThread().getName() + "执行: end...");

                latch.countDown();
            }
        });
        es2.shutdown();

        try {
            System.out.println("等待两个线程执行完毕…… ……");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }
}
