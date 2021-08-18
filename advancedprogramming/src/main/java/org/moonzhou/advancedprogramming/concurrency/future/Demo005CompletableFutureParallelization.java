/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo005CompletableFutureParallelization.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/11 19:29
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
import java.util.function.Supplier;

/**
 * 功能描述: {@link CompletableFuture}的简单示例<br>
 *     多线程并行方法使用示例
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005CompletableFutureParallelization {
    public static void main(String[] args) {

//        runAfterBothTest();

//        thenAcceptBothTest();
//        thenAcceptBothTest2();
        thenAcceptBothAsyncTest2();
    }

    /**
     * 两个CompletableFuture并行执行完，然后执行action，不依赖上两个任务的结果，无返回值
     */
    private static void runAfterBothTest() {
        //第一个异步任务，常量任务
        CompletableFuture<String> first = CompletableFuture.completedFuture("hello world");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> {
                    System.out.println("第二个异步线程开始执行");

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第二个异步线程执行结束，返回");
                    return "hello siting";
                }, executor)
                // () -> System.out.println("OK") 是第三个任务
                .runAfterBothAsync(first, () -> System.out.println("OK"), executor);

        // 无返回值
        System.out.println(future.join());

        executor.shutdown();
    }

    /**
     * 两个CompletableFuture并行执行完，然后执行action，依赖上两个任务的结果，无返回值
     *
     * //第一个任务完成再运行other，fn再依赖消费两个任务的结果，无返回值？？后面两个示例，不能说明这个问题
     * public <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other,
     *         BiConsumer<? super T, ? super U> action)
     * //两个任务异步完成，fn再依赖消费两个任务的结果，无返回值
     * public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,
     *         BiConsumer<? super T, ? super U> action)
     * //两个任务异步完成（第二个任务用指定线程池执行），fn再依赖消费两个任务的结果，无返回值
     * public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,
     *         BiConsumer<? super T, ? super U> action, Executor executor)
     */
    private static void thenAcceptBothTest() {
        // 第一个异步任务，常量任务
        CompletableFuture<String> other = CompletableFuture.completedFuture("hello world");

        CompletableFuture<Void> future1 = CompletableFuture
                // 第二个异步任务
                .supplyAsync(() -> "hello siting")
                // (w, s) -> System.out.println(s) 是第三个任务，输出：hello siting|hello world
                .thenAcceptBoth(other, (s, w) -> System.out.println(s + "|" + w));

        System.out.println(future1.join());

        System.out.println("-------------");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future2 = CompletableFuture
                // 第二个异步任务
                .supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return "hello siting";
                }, executor)
                // (w, s) -> System.out.println(s) 是第三个任务，输出：hello siting|hello world
                .thenAcceptBothAsync(other, (w, s) -> System.out.println(w + "|" + s), executor);

        // 无返回值
        System.out.println(future2.join());

        executor.shutdown();
    }

    private static void thenAcceptBothTest2() {
        // 第一个任务
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1=" + t);
                return t;
            }
        });

        // 第二个任务
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2=" + t);
                return t;
            }
        });

        // 第三个任务
        CompletableFuture<Void> f3 = f1.thenAcceptBoth(f2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer t, Integer u) {
                System.out.println("f1=" + t + ";f2=" + u + ";");
            }
        });

        System.out.println(f3.join());
    }

    /**
     * 加了Async与不加的区别还是没看出来，还是f2可能先执行，f1f2或者f2f1的顺序
     */
    private static void thenAcceptBothAsyncTest2() {
        // 第一个任务
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1=" + t);
                return t;
            }
        });

        // 第二个任务
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2=" + t);
                return t;
            }
        });

        // 第三个任务
        CompletableFuture<Void> f3 = f1.thenAcceptBothAsync(f2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer t, Integer u) {
                System.out.println("f1=" + t + ";f2=" + u + ";");
            }
        });

        System.out.println(f3.join());
    }

    /**
     * 两个CompletableFuture并行执行完，然后执行action，依赖上两个任务的结果，有返回值
     *
     * //第一个任务完成再运行other，fn再依赖消费两个任务的结果，有返回值
     * public <U,V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> other,
     * 		BiFunction<? super T,? super U,? extends V> fn)
     * //两个任务异步完成，fn再依赖消费两个任务的结果，有返回值
     * public <U,V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> other,
     *         BiFunction<? super T,? super U,? extends V> fn)
     * //两个任务异步完成（第二个任务用指定线程池执行），fn再依赖消费两个任务的结果，有返回值
     * public <U,V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> other,
     *         BiFunction<? super T,? super U,? extends V> fn, Executor executor)
     *
     */
    private static void thenCombineTest() {

    }
}
