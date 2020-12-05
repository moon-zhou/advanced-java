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
 *     通过两个独立的线程来进行示例，且交替输出俩数组
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003LockSupport02 {

    private static Thread sub1 = null;
    private static Thread sub2 = null;

    public static void main(String[] args) throws InterruptedException {
        char[] nums = "1234567".toCharArray();
        char[] chars = "ABCDEFG".toCharArray();

        sub1 = new Thread(() -> {

            for (char num : nums) {
                System.out.println(num);
                LockSupport.unpark(sub2);
                LockSupport.park();
            }

            LockSupport.unpark(sub2);
            System.out.println("thread-sub1 end");
        }, "thread-sub1");

        sub2 = new Thread(() -> {

            for (char c : chars) {
                System.out.println(c);
                LockSupport.unpark(sub1);
                LockSupport.park();
            }

            LockSupport.unpark(sub1);
            System.out.println("thread-sub2 end");
        }, "thread-sub1");


        sub1.start();
        sub2.start();

    }
}
