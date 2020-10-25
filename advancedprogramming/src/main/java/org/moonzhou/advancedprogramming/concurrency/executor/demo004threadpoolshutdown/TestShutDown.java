package org.moonzhou.advancedprogramming.concurrency.executor.demo004threadpoolshutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * shutdown方法：将线程池状态置为SHUTDOWN。平滑的关闭ExecutorService，当此方法被调用时，
 * ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。
 *
 * awaitTermination方法：接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，
 * 会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
 * <b>当前线程阻塞<b/>，直到：
 * 等所有已提交的任务（包括正在跑的和队列中等待的）执行完
 * 或者等超时时间到
 * 或者线程被中断，抛出InterruptedException
 * 然后返回true（shutdown请求后所有任务执行完毕）或false（已超时）
 *
 * shutdownNow方法：将线程池状态置为STOP。跟shutdown()一样，先停止接收外部提交的任务，忽略队列里等待的任务，尝试将正在跑的任务interrupt中断，返回未执行的任务列表。
 */
public class TestShutDown {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        service.submit(new Task());
        service.submit(new Task());
        service.submit(new LongTask());
        service.submit(new Task());

        // 当前线程的状态
        System.out.println(service.isShutdown() + " " + service.isTerminated());

        service.shutdown();
//        service.shutdownNow();

        while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("线程池没有关闭" + " " + service.isShutdown() + " " + service.isTerminated());
        }

        System.out.println("线程池已经关闭" + " " + service.isShutdown() + " " + service.isTerminated());

    }

}