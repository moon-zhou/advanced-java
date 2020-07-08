package org.moonzhou.practice.demo002loadbalance;

import org.junit.Test;
import org.moonzhou.practice.demo002loadbalance.impl.Demo001SimpleRandomLoadBalance;
import org.moonzhou.practice.demo002loadbalance.impl.Demo002SimpleWeightRandomLoadBalance;
import org.moonzhou.practice.demo002loadbalance.impl.Demo003OffsetWeightRandomLoadBalance;

/**
 * 负载均衡算法测试
 * @author moon-zhou
 */
public class LoadBalanceTest {

    @Test
    public void testSimpleRandomLoadBalance() {
        LoadBalance loadBalance = new Demo001SimpleRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }

    @Test
    public void testSimpleWeightRandomLoadBalance() {
        LoadBalance loadBalance = new Demo002SimpleWeightRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }

    @Test
    public void testOffsetWeightRandomLoadBalance() {
        LoadBalance loadBalance = new Demo003OffsetWeightRandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            System.out.println(loadBalance.getServer());
        }
    }
}