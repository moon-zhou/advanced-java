/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo003ThreadPoolShutDown.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/22 11:03
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 线程池关闭相关简单方法<br>
 *
 * shutdown只是将线程池的状态设置为SHUTWDOWN状态，平滑的关闭ExecutorService，当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。
 * shutdownNow则是将线程池的状态设置为STOP，先停止接收外部提交的任务，忽略队列里等待的任务，尝试将正在跑的任务interrupt中断，返回未执行的任务列表。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003ThreadPoolShutDown {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 6; i++) {
            try {
                int finalI = i;
                singleThreadExecutor.execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println("run: " + e.getMessage() + "\t" + finalI);
                    }

                    System.out.println("I am the " + finalI + " task");
                });
            } catch (Exception e) {
                System.out.println("main: " + e.getMessage() + "\t" + i);
            }


            if (i == 4) {
//                singleThreadExecutor.shutdown();
                singleThreadExecutor.shutdownNow();
            }
        }
    }
}
