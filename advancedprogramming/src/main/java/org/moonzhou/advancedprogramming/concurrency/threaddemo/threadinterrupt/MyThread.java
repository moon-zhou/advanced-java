/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: MyThread.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/13 19:39
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threaddemo.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;

        while (true) {
            // 查询中断标志位，不改变中断标志位
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被终止" + Thread.currentThread().isInterrupted());

                // 第一次使用返回true，并清除中断标志位
                System.out.println("interrupted1: " + Thread.interrupted());

                System.out.println(Thread.currentThread().isInterrupted());

                /**
                 * if this method were to be called twice in succession, the
                 * second call would return false (unless the current thread were
                 * interrupted again, after the first call had cleared its interrupted
                 * status and before the second call had examined it).
                 */
                System.out.println("interrupted2: " + Thread.interrupted());

                break;
            }

            /**
             * 此段代码，在执行interrupt方法的时候，会进入这里被catch，但是catch之后，isInterrupted会复位，变为false
             * 也就是再次进入循环时，if不会进入，循环不会退出
             *
             * 如果线程在wait， sleep，join的时候受阻，调用了interrupt()方法，那么不仅会清除中断标志位，还会抛出 InterruptedException异常。
             */
            /*try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("test isInterrupted: " + Thread.currentThread().isInterrupted());
                e.printStackTrace();

                // 此方式手动触发退出
                break;
            }*/

//            System.out.println("i=" + i++);
        }
    }
}
