/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TransmittableThreadLocal.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/27 17:52
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 阿里开源的TransmittableThreadLocal <br>
 *
 * 跨线程池进行值传递
 *
 * 结果为：
 * i am a transmittable parent
 * i am a transmittable parent
 * i am a new transmittable parent
 *
 * 现象：
 * 子线程可以获取到父线程设置的值，已经不局限于子线程操作时，只在第一次进行拷贝，
 * 后续如果父线程的只发生了变更，如果再进行子线程的操作，父线程变更的值还是会生效的。而InheritableThreadLocal则不能。
 * 但是子线程设置的值，如果在后续线程池化中复用时，父线程变化后，则子线程修改的值会被父线程的值覆盖。
 * （此规则与上面的规则其实是互斥的，只可选其一，TransmittableThreadLocal or InheritableThreadLocal）
 * 子线程修改的值对于父线程而言，都一样，都是隔离的。
 *
 * 原因：
 * 装饰线程池之后，在每次调用任务的时，都会将当前的主线程的TransmittableThreadLocal数据copy到子线程里面，执行完成后，再清除掉。
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TransmittableThreadLocal001 {

    static TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();// 使用TransmittableThreadLocal

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService = TtlExecutors.getTtlExecutorService(executorService); // 用TtlExecutors装饰线程池

        transmittableThreadLocal.set("i am a transmittable parent");
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println(transmittableThreadLocal.get());
                transmittableThreadLocal.set("i am a old transmittable parent");// 子线程设置新的值

            }
        });
        System.out.println(transmittableThreadLocal.get());

        TimeUnit.SECONDS.sleep(1);
        transmittableThreadLocal.set("i am a new transmittable parent");// 主线程设置新的值

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println(transmittableThreadLocal.get());
            }
        });
    }

}
