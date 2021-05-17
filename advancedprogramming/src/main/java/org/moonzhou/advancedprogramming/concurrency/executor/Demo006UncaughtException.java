/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo006UncaughtException.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/11/3 11:04
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.executor;

import java.util.concurrent.*;

/**
 * 功能描述: 通过uncaughtException处理异常<br>
 *
 * 部分参考：https://juejin.im/post/6885511940873912333
 *
 * 我们知道ThreadLocal是Thread中的本地变量，如果我们在线程的运行过程中用到了ThreadLocal，那么当线程被回收之后再次执行其他的任务的时候就会读取到之前被设置的变量，从而产生未知的问题。
 * 正确的使用方法就是在线程每次执行完任务之后，都去调用一下ThreadLocal的remove操作。
 * 或者在自定义ThreadPoolExecutor中，重写beforeExecute(Thread t, Runnable r)方法，在其中加入ThreadLocal的remove操作。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo006UncaughtException {

    public static void main(String[] args) throws Exception {
        // 测试thread使用UncaughtExceptionHandler
//        testThreadExceptionHandler();

        // 测试线程池execute使用UncaughtExceptionHandler
//        testThreadPoolExecuteExceptionHandler();

        // 测试线程池使用submit
        testThreadPoolSubmitExceptionHandler();
    }

    /**
     * 线程异常处理
     */
    private static void testThreadExceptionHandler() {

        Thread thread = new Thread(() -> {
            throw new RuntimeException("thread exception.");
        });
        thread.setUncaughtExceptionHandler(new MyExceptionHandler());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 不影响主线程执行，此处依然能够执行到
        System.out.println("main end...");
    }

    /**
     * 线程池异常处理
     * execute执行无返回结果方法时
     *
     * @throws InterruptedException
     */
    private static void testThreadPoolExecuteExceptionHandler() throws InterruptedException {
        ThreadFactory factory = new ExceptionThreadFactory(new MyExceptionHandler());
        ExecutorService pool = Executors.newFixedThreadPool(10, factory);
        Runnable runnable = () -> {
            throw new NullPointerException();
        };
        pool.execute(runnable);
        Thread.sleep(5000);
        System.out.println("finished!");
        pool.shutdown();
    }

    private static class ExceptionThreadFactory implements ThreadFactory {
        private static final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        private final Thread.UncaughtExceptionHandler handler;

        public ExceptionThreadFactory(
                Thread.UncaughtExceptionHandler handler) {
            this.handler = handler;
        }

        @Override
        public Thread newThread(Runnable run) {
            Thread thread = defaultFactory.newThread(run);
            thread.setUncaughtExceptionHandler(handler);
            return thread;
        }
    }

    private static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {

            // 业务逻辑处理异常，但是无法接着往上抛异常，影响到主流程
            System.out.println("handle exception.");
        }
    }

    /**
     * 测试线程池submit方法捕获异常
     */
    private static void testThreadPoolSubmitExceptionHandler() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            throw new NullPointerException();
        };
        Future future = pool.submit(runnable);

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("handle exception.");
            throw e;
        } finally {
            System.out.println("close thread pool.");
            pool.shutdown();
        }

        // 影响主线程，不会执行
        Thread.sleep(5000);
        System.out.println("finished!");

    }
}
