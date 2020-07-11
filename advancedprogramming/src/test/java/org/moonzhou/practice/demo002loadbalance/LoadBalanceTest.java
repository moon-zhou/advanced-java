package org.moonzhou.practice.demo002loadbalance;

import org.junit.Assert;
import org.junit.Test;
import org.moonzhou.practice.demo002loadbalance.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

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

    /**
     * 不带权重的轮询，测试线程安全
     */
    @Test
    public void testSimpleThreadSafeRoundRobinLoadBalance2() {
        LoadBalance loadBalance = new Demo006SimpleThreadSafeRoundRobinLoadBalance();

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


    /**
     * 测试偏移轮询，模拟单线程，功能测试
     */
    @Test
    public void testOffsetWeightRoundRobinLoadBalance1() {
        LoadBalance loadBalance = new Demo007OffsetWeightRoundRobinLoadBalance();

        for (int i = 0; i < 20; i++) {
            System.out.println(loadBalance.getServer());
        }

        System.out.println("end......");
    }

    /**
     * 测试偏移轮询，模拟高并发
     */
    @Test
    public void testOffsetWeightRoundRobinLoadBalance2() {
        LoadBalance loadBalance = new Demo007OffsetWeightRoundRobinLoadBalance();

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

    /**
     * 测试加权偏移轮询，模拟单线程，功能测试
     */
    @Test
    public void testThreadSafeOffsetWeightRoundRobinLoadBalance1() {
        LoadBalance loadBalance = new Demo008ThreadSafeOffsetWeightRoundRobinLoadBalance();

        for (int i = 0; i < 20; i++) {
            System.out.println(loadBalance.getServer());
        }

        System.out.println("end......");
    }

    /**
     * 测试加权偏移轮询，模拟高并发
     */
    @Test
    public void testThreadSafeOffsetWeightRoundRobinLoadBalance2() {
        Map<String, Integer> ipWeightList = ServerInfo.IP_WEIGHTLIST_LITTLE;

        // 权重求和
        int weightSum = ipWeightList.values().stream().mapToInt(a -> a).sum();
        int roundTimes = 5;
        int loopTimes = weightSum * roundTimes;

        // 获取机器结果
        Map<String, Integer> serverChosenMapCount = new HashMap<>();

        LoadBalance loadBalance = new Demo008ThreadSafeOffsetWeightRoundRobinLoadBalance();

        CountDownLatch latch = new CountDownLatch(loopTimes);
        for (int i = 0; i < loopTimes; i++) {
            new Thread(() -> {

                String serverIp = loadBalance.getServer();

                // 原始测试，输出数据，手动比对
                System.out.println(Thread.currentThread().getName() + "  " + serverIp);

                // 因为本身是循环里单线程，其他场景操作时，需要考虑此处的线程安全问题
//                synchronized (this) {
                    if (serverChosenMapCount.containsKey(serverIp)) {
                        int count = serverChosenMapCount.get(serverIp);
                        serverChosenMapCount.put(serverIp, ++count);
                    } else {
                        serverChosenMapCount.put(serverIp, 1);
                    }
//                }

                latch.countDown();
            }, "线程" + String.valueOf(i)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(serverChosenMapCount);

        // 循环次数*权重，即为预计可以获取的对应机器的次数
        for (Map.Entry<String, Integer> entry : ipWeightList.entrySet()) {
            Assert.assertEquals(entry.getValue() * roundTimes, serverChosenMapCount.get(entry.getKey()).intValue());
        }

        System.out.println("end......");
    }

}