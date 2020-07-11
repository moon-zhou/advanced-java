/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo004FullRoundRobinLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/8 15:33
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:完全轮询算法<br>
 *     不带权重的轮询算法
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo006SimpleThreadSafeRoundRobinLoadBalance implements LoadBalance {

    /**
     * 未初始化默认值为0，
     * 并发安全，是用原子包装类，但是因为有set的单独方法，其实还是有安全问题，需要加上锁，保证整个重置和最终获取值，以及获取完值之后+1的操作原子性。
     *
     * 也可以简化成无锁，获取值是，不是直接使用index的位置，而是使用index % ipList.size()来作为数组的位置，这样只需要Atomic保证获取值和++操作的原子性即可
     *
     */
    private static AtomicInteger index = new AtomicInteger();

    @Override
    public String getServer() {

        List<String> ipList = ServerInfo.IP_LIST;

        int andIncrement = index.getAndIncrement();

        // 模拟线程占用时间，来检测线程安全问题
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ipList.get(andIncrement % ipList.size());
    }
}
