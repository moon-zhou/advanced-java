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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:完全轮询算法<br>
 *     不带权重的轮询算法
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004SimpleRoundRobinLoadBalance implements LoadBalance {

    /**
     * 未初始化默认值为0，
     * 并发安全，是用原子包装类，但是因为有set的单独方法，其实还是有安全问题，需要加上锁，保证整个重置和最终获取值，以及获取完值之后+1的操作原子性。
     * 下一个示例做了修复
     *
     */
    private static int index;

    private static AtomicInteger atomicIndex = new AtomicInteger();

    @Override
    public String getServer() {

//        return unSafe1();

        return unSafe2();
    }

    private String unSafe1() {
        List<String> ipList = ServerInfo.IP_LIST;

        if (index >= ipList.size()) {
            index=0;
        }

        String ip = ipList.get(index);

        // 模拟线程不安全
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        index++;

        return ip;
    }

    private String unSafe2() {
        List<String> ipList = ServerInfo.IP_LIST;

        if (atomicIndex.get() >= ipList.size()) {
            atomicIndex.set(0);
        }

        // 模拟线程不安全
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 此处会出现下标越界的情况，因为有的线程进来的时候，get还没有超过list下标，但是执行到这里的时候，别的线程也在操作的时候，将atomicIndex增加超过list长度了。
        String ip = ipList.get(atomicIndex.getAndIncrement());

        return ip;
    }
}
