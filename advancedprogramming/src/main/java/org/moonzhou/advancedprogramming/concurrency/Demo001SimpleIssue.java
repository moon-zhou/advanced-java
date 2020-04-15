package org.moonzhou.advancedprogramming.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单并发问题<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/15 11:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001SimpleIssue {

    /**
     * 线程池创建的线程数 2*核数
     * <p>
     * CPU密集型和IO密集型
     */
    private static int threadNum = 16;

    /**
     * 库存
     */
    private static Integer inventory = 1001;

    private static final int NUM = 1001;

    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();

//    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadNum, threadNum, 10L, TimeUnit.SECONDS, linkedBlockingDeque);

        final CountDownLatch countDownLatch = new CountDownLatch(NUM);

        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(
                    () -> {
                        inventory--;
                        System.out.println("线程执行：" + Thread.currentThread().getName());

                        countDownLatch.countDown();
                    }
            );
        }

        threadPoolExecutor.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + "    总耗时：" + (end - start) + "    库存数为：" + inventory);
    }
}
