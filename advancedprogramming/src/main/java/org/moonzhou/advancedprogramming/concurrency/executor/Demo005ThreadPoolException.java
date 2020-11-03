/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo005ThreadPoolException.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/25 17:20
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述: 处理线程池中的异常<br>
 *     线程池内部的RuntimeException，无法被线程外部捕获，且不影响线程池状态。
 *
 * 当前主线程不受影响，线程池没有显示关闭，运行时异常也不影响线程池状态（未被运行时异常关闭）。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005ThreadPoolException {

    public static void main(String[] args) {
        try {
            wrongSubmit();
        } catch (InterruptedException e) {
            System.err.println("exception.........");
        }
    }

    public static void wrongSubmit() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable runnable= ()->{
            throw new NullPointerException();
        };
        pool.execute(runnable);
        Thread.sleep(5000);
        System.out.println("finished!");
    }

}
