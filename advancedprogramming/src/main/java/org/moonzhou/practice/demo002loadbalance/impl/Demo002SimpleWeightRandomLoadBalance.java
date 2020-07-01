/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo002SimpleWeightRandomLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/1 19:36
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 功能描述:带权重的简单随机负载均衡<br>
 *     简单实现，参考不带权重的简单随机，权重是几，就在List里放几个该ip，保证该ip在整体的List里比重为权重与总权重的笔。
 *     ip个数/list总数 = 权重值/总权重值
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002SimpleWeightRandomLoadBalance implements LoadBalance {
    @Override
    public String getServer() {

        // 转换后的list
        List<String> weithgIpContertList = new ArrayList<>();

        Map<String, Integer> ipWeight = ServerInfo.IP_WEIGHTLIST;
        ipWeight.forEach((ip, weight) -> {

            for (int i = 0; i < weight; i++) {
                weithgIpContertList.add(ip);
            }

        });

        Random random = new Random();

        return weithgIpContertList.get(random.nextInt(weithgIpContertList.size()));
    }
}
