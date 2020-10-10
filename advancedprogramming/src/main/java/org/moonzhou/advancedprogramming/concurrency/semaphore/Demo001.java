/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/10 8:37
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.semaphore;

import java.util.concurrent.*;

/**
 * 功能描述: 信号量示例<br>
 * <p>
 * 应用场景：用于流量控制，特别是公用资源有限的应用场景，比如数据库连接。
 * 控制访问的流量（数量），超过的部分则会阻塞等待现有访问的线程执行完。执行完之后，阻塞线程或得到许可证即可进行执行。
 * <p>
 * 本示例来自《Java并发编程的艺术》
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    // 控制线程并发数为10，即使有30个线程
    private static Semaphore semaphore = new Semaphore(10);

    private static CountDownLatch cdl = new CountDownLatch(30);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int batchShow = i;

            threadPool.execute(() -> {
                try {
                    semaphore.acquire();

                    // 为方便查看输出信息，每10条（一批）打一行分隔符
                    if (batchShow % 10 == 0) {
                        System.out.println("===============");
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + "save data");

                    // 模拟耗时处理
                    TimeUnit.SECONDS.sleep(5);

                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }

            });
        }

        try {
            cdl.await();

            System.out.println("\n" + "it is end, shutdown thread pool.");

            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
