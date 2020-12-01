/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001WaitNotifyCase.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/1 20:17
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadsyn;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 线程同步之wait-notify示例<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001WaitNotifyCase {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock) {
                try {
                    System.out.println("thread-one doing");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread-one wait, release synchronized lock...");
                    System.out.println("waiting...");
                    lock.wait();
                    System.out.println("thread-one waiting end...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread-one done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-one").start();

        new Thread(()->{
            synchronized (lock) {
                try {

                    System.out.println("thread-two doing...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("thread-two notify, but waiting for done.");
                    lock.notify();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("thread-two done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-two").start();
    }
}
