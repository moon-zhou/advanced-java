package org.moonzhou.advancedprogramming.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@Slf4j
public class ThreadPoolHelper {

    private static final int POOL_SIZE = 40;//线程池大小

    //订单任务线程池
    private static ThreadPoolExecutor comitTaskPool = (ThreadPoolExecutor) new ScheduledThreadPoolExecutor(POOL_SIZE,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());


    /**
     * 执行订单任务
     *
     * @param comitTask
     */
    public static void executeTask(Runnable comitTask) {
        comitTaskPool.execute(comitTask);
        /*log.debug("【线程池任务】线程池中线程数：" + comitTaskPool.getPoolSize());
        log.debug("【线程池任务】队列中等待执行的任务数：" + comitTaskPool.getQueue().size());
        log.debug("【线程池任务】已执行完任务数：" + comitTaskPool.getCompletedTaskCount());*/

        System.out.println("【线程池任务】线程池中线程数：" + comitTaskPool.getPoolSize());
        System.out.println("【线程池任务】队列中等待执行的任务数：" + comitTaskPool.getQueue().size());
        System.out.println("【线程池任务】已执行完任务数：" + comitTaskPool.getCompletedTaskCount());
    }


    /**
     * 关闭线程池
     * 未关闭时，等待3s再进行判断，如果未关闭，直接强制shutdownNow
     */
    public static void shutdown() {
//        log.debug("shutdown comitTaskPool...");
        System.out.println("shutdown comitTaskPool...");
        comitTaskPool.shutdown();
        try {
            if (!comitTaskPool.isTerminated()) {
//                log.debug("直接关闭失败[" + comitTaskPool.toString() + "]");
                System.out.println("直接关闭失败[" + comitTaskPool.toString() + "]");
                comitTaskPool.awaitTermination(3, TimeUnit.SECONDS);
                if (comitTaskPool.isTerminated()) {
//                    log.debug("成功关闭[" + comitTaskPool.toString() + "]");
                    System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
                } else {
//                    log.debug("[" + comitTaskPool.toString() + "]关闭失败，执行shutdownNow...");
                    System.out.println("[" + comitTaskPool.toString() + "]关闭失败，执行shutdownNow...");
                    if (comitTaskPool.shutdownNow().size() > 0) {
//                        log.debug("[" + comitTaskPool.toString() + "]没有关闭成功");
                        System.out.println("[" + comitTaskPool.toString() + "]没有关闭成功");
                    } else {
//                        log.debug("shutdownNow执行完毕，成功关闭[" + comitTaskPool.toString() + "]");
                        System.out.println("shutdownNow执行完毕，成功关闭[" + comitTaskPool.toString() + "]");
                    }
                }
            } else {
//                log.debug("成功关闭[" + comitTaskPool.toString() + "]");
                System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
            }
        } catch (InterruptedException e) {
//            log.warn("接收到中断请" + comitTaskPool.toString() + "停止操作");
            System.out.println("接收到中断请" + comitTaskPool.toString() + "停止操作");
        }
    }

    /**
     * 关闭成功的等待超时时间，在<code>timeout<code/>之内未关闭完成，直接shutdownNow
     * @param timeout
     */
    public static void shutdown(long timeout) {
//        log.debug("shutdown comitTaskPool...");
        System.out.println("shutdown comitTaskPool...");
        comitTaskPool.shutdown();
        try {
            if (!comitTaskPool.isTerminated()) {
//                log.debug("直接关闭失败[" + comitTaskPool.toString() + "]");
                System.out.println("直接关闭失败[" + comitTaskPool.toString() + "]");
                comitTaskPool.awaitTermination(timeout, TimeUnit.SECONDS);
                if (comitTaskPool.isTerminated()) {
//                    log.debug("成功关闭[" + comitTaskPool.toString() + "]");
                    System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
                } else {
//                    log.debug("[" + comitTaskPool.toString() + "]关闭失败，执行shutdownNow...");
                    System.out.println("[" + comitTaskPool.toString() + "]关闭失败，执行shutdownNow...");
                    if (comitTaskPool.shutdownNow().size() > 0) {
//                        log.debug("[" + comitTaskPool.toString() + "]没有关闭成功");
                        System.out.println("[" + comitTaskPool.toString() + "]没有关闭成功");
                    } else {
//                        log.debug("shutdownNow执行完毕，成功关闭[" + comitTaskPool.toString() + "]");
                        System.out.println("shutdownNow执行完毕，成功关闭[" + comitTaskPool.toString() + "]");
                    }
                }
            } else {
//                log.debug("成功关闭[" + comitTaskPool.toString() + "]");
                System.out.println("成功关闭[" + comitTaskPool.toString() + "]");
            }
        } catch (InterruptedException e) {
//            log.warn("接收到中断请" + comitTaskPool.toString() + "停止操作");
            System.out.println("接收到中断请" + comitTaskPool.toString() + "停止操作");
        }
    }
}