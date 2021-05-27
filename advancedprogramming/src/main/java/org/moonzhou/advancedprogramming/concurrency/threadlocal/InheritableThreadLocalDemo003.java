/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: InheritableThreadLocalDemo003.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/25 20:06
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: InheritableThreadLocal示例<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InheritableThreadLocalDemo003 {

    static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        inheritableThreadLocal.set("i am a inherit parent");
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // 获取到父线程设置的值（父线程拷贝过来的）
                System.out.println(inheritableThreadLocal.get());

                // 子线程中设置新的值（线程隔离，ThreadLocal特性，继承ThreadLocal，重写了get方法，只有同一个线程才能获取到）
                inheritableThreadLocal.set("i am a old inherit parent");

            }
        });

        TimeUnit.SECONDS.sleep(1);
        inheritableThreadLocal.set("i am a new inherit parent"); // 主线程设置新的值（只能主线程获取到-main线程）

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // 还是只能获取到子线程里设置的值（ThreadLocal特性，继承ThreadLocal，重写了get方法）
                System.out.println(inheritableThreadLocal.get());
            }
        });


        executorService.shutdown();
    }
}
