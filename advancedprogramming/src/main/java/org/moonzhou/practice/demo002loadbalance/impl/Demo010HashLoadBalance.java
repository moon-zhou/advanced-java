/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo010HashLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/12 16:31
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 功能描述:哈希算法负载均衡--哈希环<br>
 *     根据某个值生成一个哈希值，然后对应到某台服务器上去
 *     e.g.
 *     如果根据用户，就比较巧妙的解决了负载均衡下Session共享的问题，用户小明走的永远是A服务器，用户小笨永远走的是B服务器。
 *
 * 一致性哈希算法--哈希环
 * 普通哈希环会有<b>哈希偏斜</b>问题，因此引入了<b>虚拟节点<b/>的概念，虚拟节点越多，负载越均衡，尤其是在有机器宕机的情况下。（微积分）
 *
 * reference: https://juejin.im/post/5c827b1e6fb9a049ff4eed25
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo010HashLoadBalance implements LoadBalance {

    String client;

    public Demo010HashLoadBalance(String client) {
        this.client = client;
    }

    @Override
    public String getServer() {

        List<String> ipWeightList = ServerInfo.IP_LIST;

        int nodeCount = 20;
        final TreeMap<Integer, String> treeMap = new TreeMap();

        // 按照虚拟节点数目，将机器映射存储进去，key为机器ip相关的hash值，此算法不能保证hash值的均匀散列性
        ipWeightList.forEach(s -> {
            for (int i = 0; i < nodeCount; i++) {
                treeMap.put((s + "--服务器---" + i).hashCode(), s);
            }
        });

        // 参数值的hashCode计算，不一定保证其散列在原本hash环上的均匀性
        int clientHash = client.hashCode();
        // 获取一个子集。其所有对象的 key 的值大于等于 fromKey
        SortedMap<Integer, String> subMap = treeMap.tailMap(clientHash);

        Integer firstHash;
        if (subMap.size() > 0) {
            firstHash = subMap.firstKey();
        } else {
            firstHash = treeMap.firstKey();
        }

        return treeMap.get(firstHash);
    }
}
