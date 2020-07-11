/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo006SimpleWeightRoundRobinLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/10 17:18
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:线程安全的加权轮询算法<br>
 *     偏移量方式
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo008ThreadSafeOffsetWeightRoundRobinLoadBalance implements LoadBalance {

    /**
     * 轮询的索引位置
     */
    private static final AtomicInteger ATOMIC_INDEX = new AtomicInteger();

    @Override
    public String getServer() {
        Map<String, Integer> ipWeightList = ServerInfo.IP_WEIGHTLIST_LITTLE;

        // 权重求和
        int weightSum = ipWeightList.values().stream().mapToInt(a -> a).sum();

        // 模拟线程占用时间，来检测线程安全问题，更容易检测出
        int index = ATOMIC_INDEX.getAndIncrement();
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 计算偏移后所取数据的位置，同时总计数每调用一次，都新增一次，使用AtomicInteger保证线程安全
         *
         */
        int offset = index % weightSum;
        for (Map.Entry<String, Integer> entry : ipWeightList.entrySet()) {
            if (offset - entry.getValue() < 0) {
                return entry.getKey();
            }

            offset -= entry.getValue();
        }

        return null;
    }
}
