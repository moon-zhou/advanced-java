/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: PrintOldEvenWaitNotify.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/6 20:47
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo004OldEvenPrintByTurn;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PrintOldEvenWaitNotify implements IPrintOldEven {

    /**
     * 交替打印的变量
     */
    private static volatile int count = 0;

    /**
     * 打印的最大值
     */
    private static final int MAX_PRINT_NUM = 100;

    private static final Object lock = new Object();

    @Override
    public void printByTurns() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {

                    for (; count < MAX_PRINT_NUM; ) {
                        System.out.println(Thread.currentThread().getName() + "    " + (count++));

                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    lock.notifyAll();
                }
            }
        };

        new Thread(runnable, "偶数线程").start();
        new Thread(runnable, "奇数线程").start();

    }
}
