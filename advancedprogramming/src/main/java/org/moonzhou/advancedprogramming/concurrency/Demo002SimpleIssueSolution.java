package org.moonzhou.advancedprogramming.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单并发问题解决方案<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/15 11:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002SimpleIssueSolution {

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

    /**
     * CountDownLatch初始化需要同步的线程执行数目，也就是for循环里countDown的次数，也就是库存卖光的次数
     */
    private static final int NUM = 1001;

    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();

    /**
     * 重入锁，控制并发扣减库存的问题
     */
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        // guava里的实现
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("countDownLatchDemo-pool-%d").build();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadNum, threadNum, 10L,
                TimeUnit.SECONDS, linkedBlockingDeque, threadFactory, new ThreadPoolExecutor.AbortPolicy());

        final CountDownLatch countDownLatch = new CountDownLatch(NUM);

        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(
                    () -> {
                        reentrantLock.lock();

                        inventory--;
                        System.out.println("线程执行：" + Thread.currentThread().getName());

                        System.out.println("线程池中现在的线程数目是：" + threadPoolExecutor.getPoolSize() + ",  队列中正在等待执行的任务数量为：" +
                                threadPoolExecutor.getQueue().size());

                        reentrantLock.unlock();

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
        System.out.println("执行线程数：" + threadNum + "    总耗时：" + (end - start) + "    库存数为：" + inventory);
    }
}
