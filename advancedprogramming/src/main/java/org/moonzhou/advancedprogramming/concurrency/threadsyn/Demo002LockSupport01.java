/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo002LockSupport01.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/3 8:45
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadsyn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 功能描述: 使用LockSupport来进行线程间同步的示例<br>
 *     通过主线程和单独的线程来进行示例演示
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002LockSupport01 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("thread main doing...");

        Thread mainThread = Thread.currentThread();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " start.");
            try {
                TimeUnit.SECONDS.sleep(5);

                System.out.println(Thread.currentThread().getName() + " done and to unpark main thread.");
                LockSupport.unpark(mainThread);
                // 如果有线程间交互的操作，unpark之后最好不要有别的操作行为，否则还是会有并发问题。
                System.out.println(Thread.currentThread().getName() + " end.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-sub").start();

        System.out.println("thread main done and to park");
        // 主线程挂起
        LockSupport.park();

        System.out.println("thread main continue doing");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("thread main done");
    }
}
