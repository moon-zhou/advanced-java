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

import java.util.concurrent.*;

/**
 * 功能描述: {@link CompletableFuture}的简单示例<br>
 *     get()和join的区别示例，都是阻塞等待返回结果的方法，但是get需要显示的catch异常，而join则是unchecked
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003CompletableFutureException {

    public static void main(String[] args) {
        completableUncheckedException();

        System.out.println("-------------------");

        completableCheckedException();
    }

    private static void completableUncheckedException() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("it's runnable implementation.");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("runnable way, then throw exception.");
            throw new RuntimeException("CompletableFuture runnable exception.");
        });

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("supply way, then throw exception.");
            double a = 2 / 0;

            String result = "it's supplier implementation.";
            return result;
        });

        // unchecked exception，不强制catch，此处可不写try-catch，但如果不catch，如果抛出异常，则阻断执行
        try {
            System.out.println("runnable return: " + runAsync.join());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("supply return:" + supplyAsync.join());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void completableCheckedException() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("it's runnable implementation.");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("runnable way, then throw exception.");
            throw new RuntimeException("CompletableFuture runnable exception.");
        });

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("supply way, then throw exception.");
            double a = 2 / 0;

            String result = "it's supplier implementation.";
            return result;
        });

        // checked exception，必须try-catch，否则编译不通过
        try {
            System.out.println("runnable return: " + runAsync.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("runAsync exception.");
            e.printStackTrace();
        }

        try {
            System.out.println("supply return:" + supplyAsync.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("supplyAsync exception.");
            e.printStackTrace();
        }

    }

}
