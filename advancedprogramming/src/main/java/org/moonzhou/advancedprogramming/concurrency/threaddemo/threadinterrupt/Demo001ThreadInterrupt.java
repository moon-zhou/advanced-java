/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001ThreadInterrupt.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/13 19:37
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
public class Demo001ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start...");

        Thread thread = new MyThread();
        thread.start();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("start to cll interrupt...");

        /**
         * 调用让线程置为中断
         * 线程中断仅仅是设置线程的中断状态位，不会停止线程。需要用户自己去监视线程的状态为并做处理。
         */
        thread.interrupt();

        System.out.println(Thread.currentThread().getName() + " end...");
    }
}
