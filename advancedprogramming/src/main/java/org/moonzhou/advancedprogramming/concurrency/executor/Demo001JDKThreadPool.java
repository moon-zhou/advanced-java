package org.moonzhou.advancedprogramming.concurrency.executor;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.*;

/**
 * jdk默认的线程池实现<br>
 * 虽然java开发规范里不建议使用，但此处仅仅是学习demo，实际开发中遵循开发规范
 *
 * @author moon-zhou
 * @date 2020/5/22 10:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001JDKThreadPool {

    public static void main(String[] args) {
//        testScheduledThreadPool();

        testCachedThreadPool();

//        testSingleThreadExecutor();

//        testFixedThreadPool();
    }

    /**
     * 测试newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     * 一般可做定时器使用
     */
    private static void testScheduledThreadPool() {
        // 参数是线程的数量
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        /**
         * 第二个参数，是首次执行该线程的延迟时间，之后失效
         * 第三个参数是，首次执行完之后，再过该段时间再次执行该线程，具有周期性
         */
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println(LocalDateTime.now().getSecond());

            }
        }, 10, 3, TimeUnit.SECONDS);
    }

    /**
     * newCachedThreadPool创建一个可缓存线程池，
     * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     */
    public static void testCachedThreadPool() {
        CountDownLatch countDownLatch = new CountDownLatch(30);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            final int index = i;

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {

                    try {
                        TimeUnit.MILLISECONDS.sleep(new RandomDataGenerator().nextInt(1000, 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(index + ":" + LocalDateTime.now().getSecond());

                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cachedThreadPool.shutdown();
    }

    /**
     * newSingleThreadExecutor 创建一个单线程化的线程池，
     * 它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    public static void testSingleThreadExecutor() {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 11; i++) {
            final int index = i;

            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(new RandomDataGenerator().nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 会按顺序打印
                    System.out.println(index);

                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        singleThreadExecutor.shutdown();
    }


    /**
     * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     */
    public static void testFixedThreadPool() {
        CountDownLatch countDownLatch = new CountDownLatch(20);

        // 当参数为1的时候，可以控制线程的执行顺序，类似join的作用
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            final int index = i;

            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {

                    try {
                        TimeUnit.MILLISECONDS.sleep(new RandomDataGenerator().nextInt(1000, 5000));

                        System.out.println(index);

                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fixedThreadPool.shutdown();
    }
}
