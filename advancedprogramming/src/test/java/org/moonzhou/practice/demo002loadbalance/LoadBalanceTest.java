package org.moonzhou.practice.demo002loadbalance;

import org.junit.Test;
import org.moonzhou.practice.demo002loadbalance.impl.*;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.ComparisonChain.start;

/**
 * 负载均衡算法测试
 * @author moon-zhou
 */
public class LoadBalanceTest {

    /**
     * 简单随机
     */
    @Test
    public void testSimpleRandomLoadBalance() {
        LoadBalance loadBalance = new Demo001SimpleRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }

    /**
     * 带权重的简单随机
     */
    @Test
    public void testSimpleWeightRandomLoadBalance() {
        LoadBalance loadBalance = new Demo002SimpleWeightRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }

    /**
     * 带权重的随机，使用偏移量，减少空间复杂度
     */
    @Test
    public void testOffsetWeightRandomLoadBalance() {
        LoadBalance loadBalance = new Demo003OffsetWeightRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }

    /**
     * 不带权重的轮询，测试线程不安全
     */
    @Test
    public void testSimpleRoundRobinLoadBalance() {
        LoadBalance loadBalance = new Demo004SimpleRoundRobinLoadBalance();

        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                /*try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                System.out.println(Thread.currentThread().getName() + "  " + loadBalance.getServer());

                latch.countDown();
            }, "线程" + String.valueOf(i)).start();

        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end......");
    }

    /**
     * 不带权重的轮询，测试线程安全
     */
    @Test
    public void testSimpleThreadSafeRoundRobinLoadBalance() {
        LoadBalance loadBalance = new Demo005SimpleThreadSafeRoundRobinLoadBalance();

        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "  " + loadBalance.getServer());

                latch.countDown();
            }, "线程" + String.valueOf(i)).start();

        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end......");
    }
}