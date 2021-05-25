/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: Demo002ThreadLocalMemory.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/21 14:31
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import lombok.Data;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述: ThreadLocal 内存泄漏示例<br>
 *     配置启动参数：-Xms800m -Xmx800m -XX:+PrintGCDetails
 *
 * 该示例存疑，更多的是我们使用时需要在使用完之后remove
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002ThreadLocalMemoryLeak {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    threadLocal.set(new Demo());
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (Objects.nonNull(threadLocal)) {
                        // 为防止内存泄漏,当前线程用完,清除掉 value
//                        threadLocal.remove();
//                        System.out.println("remove......");
                    }
                }
            });
        }
        Thread.sleep(5000);

//        executorService.shutdown();

        threadLocal = null;
        while (true) {
            Thread.sleep(2000);
        }
    }

    @Data
    static class Demo {
        //
        private Demo[] demos = new Demo[1024 * 1024 * 5];
    }

}
