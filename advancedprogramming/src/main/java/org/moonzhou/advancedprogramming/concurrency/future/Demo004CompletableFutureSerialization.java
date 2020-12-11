/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo003CompletableFutureSerialization.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/9 10:57
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 功能描述: {@link CompletableFuture}的简单示例<br>
 * 多线程串行化方法使用示例
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004CompletableFutureSerialization {

    public static void main(String[] args) {

//        thenRunTest();

        System.out.println("---------------------");

//        thenAcceptTest();

//        thenApplyTest();

//        thenComposeTest();

        completableAsyncDiff();

//        whenCompleteTest();
    }

    /**
     * <code>thenRun</code>方法的一系列示例
     * 任务完成则运行action，不关心上一个任务的结果（Runnable），无返回值
     */
    private static void thenRunTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("supply async in...");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("supply async doing...");
                    return "hello siting";
                }, executor)
                .thenRunAsync(() -> System.out.println("OK"), executor);

        /*CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "hello siting", executor)
                .thenRunAsync(() -> System.out.println("OK"), executor);*/

        future.join();

        executor.shutdown();
    }

    /**
     * 任务完成则运行action，依赖上一个任务的结果，无返回值
     */
    private static void thenAcceptTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "hello siting", executor)
                .thenAcceptAsync(System.out::println, executor);// 打印前一次执行返回的结果
        executor.shutdown();

        /*CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "hello siting")
                .thenAcceptAsync(System.out::println);*/

    }

    /**
     * 任务完成则运行fn，依赖上一个任务的结果，有返回值
     */
    private static void thenApplyTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenApplyAsync(data -> {
                    // 此处入参为上一个任务返回的"hello world"
                    System.out.println(data);
                    return "OK";
                }, executor);

        // 阻塞
        System.out.println(future.join());

        executor.shutdown();
    }

    /**
     * thenCompose - 任务完成则运行fn，依赖上一个任务的结果，有返回值
     */
    private static void thenComposeTest() {
        // 第一个异步任务，常量任务
        CompletableFuture<String> f = CompletableFuture.completedFuture("OK");
        // 第二个异步任务
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenComposeAsync(data -> {
                    System.out.println(data);
                    return f; //使用第一个任务作为返回
                }, executor);

        System.out.println(future.join());

        executor.shutdown();

    }

    /**
     * 带有Async后缀使用的区别
     * 带有Async的方法，执行时使用线程池的线程，而不带Async使用主线程进行执行？？有疑问
     */
    private static void completableAsyncDiff() {
        System.out.println("main thread name: " + Thread.currentThread().getName());

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync thread name: " + Thread.currentThread().getName());
        }).thenRun(() -> {
            // 这个有时候是主线程执行，有时候是线程池执行？？
            System.out.println("thenRun thread name: " + Thread.currentThread().getName());
        }).thenRunAsync(() -> {
            System.out.println("thenRunAsync thread name: " + Thread.currentThread().getName());
        });

        // 阻塞
        System.out.println(runAsync.join());

        CompletableFuture<Void> run = CompletableFuture.supplyAsync(() -> {
            System.out.println("runAsync thread name: " + Thread.currentThread().getName());
            return "hi";
        }).thenAccept(data -> {
            System.out.println("thenAccept thread name: " + Thread.currentThread().getName());
        }).thenAcceptAsync(data -> {
            System.out.println("thenRunAsync thread name: " + Thread.currentThread().getName());
        });

        // 阻塞
        System.out.println(run.join());
    }

    /**
     * 当CompletableFuture的计算结果完成，或者抛出异常的时候，可以执行特定的Action
     * whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
     * whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
     */
    private static void whenCompleteTest() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                int i = 12/0;
            }
            System.out.println("run end ...");
        });

        // 执行结束时进入（如果被异常抓了，处理之后再进入）
        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });

        // 异常时会进入
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return null;
            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
