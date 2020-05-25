package org.moonzhou.advancedprogramming.concurrency.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 初始化线程池：核心线程数，最大线程数<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/25 19:20
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002ThreadPool {
    public static void main(String[] args) {
//        threadPoolDemo();

        threadPoolReject();
    }

    /**
     * 基本简单使用
     */
    private static void threadPoolDemo() {
        // 使用只能5个有限队列，corePoolSize=2, maxPoolSize=10
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
                0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        // 创建15个线程：原始初始化最大线程数为10+队列5=最大执行任务数
        for (int i = 0; i < 15; i++) {
            final int a = i;
            // 无返回执行的任务
            executor.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500L);
                    System.out.println("Tread name: " + Thread.currentThread().getName()
                            + "  index: " + a + "   --- " + executor.getQueue().size()
                            + "  poolSize: " + executor.getPoolSize()
                            + "  corePoolSize: " + executor.getCorePoolSize());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    private static void threadPoolReject() {

        // guava里的实现
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("tread-pool-reject-%d").build();

        // 使用只能5个有限队列，corePoolSize=2, maxPoolSize=10
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10,
                0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        // 创建15个线程：原始初始化最大线程数为10+队列5=最大执行任务数
        for (int i = 0; i < 20; i++) {
            try {
                final int a = i;
                executor.execute(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500L);
                        System.out.println("Tread name: " + Thread.currentThread().getName()
                                + "  index: " + a + "   --- " + executor.getQueue().size()
                                + "  poolSize: " + executor.getPoolSize()
                                + "  corePoolSize: " + executor.getCorePoolSize());
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                // 会抛出任务拒绝的异常，打印消息
                e.printStackTrace();

                // 如果没有睡一会，那么将打印5条被拒的异常，睡一会之后，只有第一次会打印被拒，后面因为任务执行完成之后，所以可以得到线程池空间，进行执行
                try {
                    TimeUnit.MILLISECONDS.sleep(3000L);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        System.out.println("关闭线程池");
        executor.shutdown();


        /*while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Tread name: " + Thread.currentThread().getName()
                    + "  poolSize: " + executor.getPoolSize()
                    + "  corePoolSize: " + executor.getCorePoolSize());
        }*/
    }
}
