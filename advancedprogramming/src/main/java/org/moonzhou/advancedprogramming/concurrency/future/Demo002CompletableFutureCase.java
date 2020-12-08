/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo002CompletableFutureCase.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/7 9:06
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述: {@link CompletableFuture}的简单示例<br>
 *     通过Runnable以及Supplier的方式来进行使用
 *     没有指定Executor的方法会使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002CompletableFutureCase {

    public static void main(String[] args) {
        CompletableNoExecutor();

//        CompletableWithExecutor();
    }

    private static void CompletableNoExecutor() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("it's runnable implementation.");
        });

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            String result = "it's supplier implementation.";
            return result;
        });

        System.out.println("runnable return: " + runAsync.join());
        System.out.println("supply return:" + supplyAsync.join());

    }

    private static void CompletableWithExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("it's runnable implementation.");
        }, executor);

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            String result = "it's supplier implementation.";
            return result;
        }, executor);

        System.out.println("runnable return: " + runAsync.join());
        System.out.println("supply return:" + supplyAsync.join());

        executor.shutdown();
    }
}
