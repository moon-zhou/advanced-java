package org.moonzhou.advancedprogramming.concurrency.countdownlatch.Demo002CountLatchTransfer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * CountDownLatch传递使用测试<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/15 19:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParallelLimit {
    /**
     * 线程池创建的线程数 2*核数
     * <p>
     * CPU密集型和IO密集型
     */
    private static int threadNum = 100;

    /**
     * 线程池阻塞队列数据结构
     */
    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();

    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("countDownLatchDemo-pool-%d").build();

        /**
         * 此处因为是Runnable接口里有CountDownLatch的await方法，所以，线程池的大小不能小于执行的for循环的大小，否则会出现已执行的线程阻塞住，
         * 未执行的在线程池队等待队列里，无法进入线程池里进行执行
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(threadNum, threadNum, 10L,
                TimeUnit.SECONDS, linkedBlockingDeque, threadFactory, new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }

        pool.shutdown();
        /*try {

            cdl.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
