/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo009WeightSmoothRoundRobinLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/12 9:07
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:加权平滑轮询算法<br>
 *
 * 算法核心：
 * 假设有 N 台实例 S = {S1, S2, …, Sn}，配置权重 W = {W1, W2, …, Wn}，有效权重 CW = {CW1, CW2, …, CWn}。
 * 每个实例 i 除了存在一个配置权重 Wi 外，还存在一个当前有效权重 CWi，且 CWi 初始化为 Wi；
 * 指示变量 currentPos 表示当前选择的实例 ID，初始化为 -1；所有实例的配置权重和为 weightSum；
 *
 * 示例：
 * 机器-权重：    A:5    B:1    C:1
 * 配置权重-W： 5,1,1
 * 配置权重和-weightSum：5 + 1 + 1 = 7
 *
 * 有效权重（一直在变，初始化为配置权重，即5,1,1），设置（计算过程）如下：
 * currentWeigh += weight            max(CurrentWeight)    result/currentPos    max(currentWeight) -= sum(weight)
 * 5,1,1                             5                     5->A / 0             5-7,1,1 = -2,1,1
 * (-2,1,1) + (5,1,1) = (3,2,2)      3                     3->A / 0             3-7,2,2 = -4,2,2
 * (-4,2,2) + (5,1,1) = (1,3,3)      3                     3->B / 1             1,3-7,3 = 1,-4,3
 * (1,-4,3) + (5,1,1) = (6,-3,4)     6                     6->A / 0             6-7,-3,4 = -1,-3,4
 * (-1,-3,4)+ (5,1,1) = (4,-2,5)     5                     5->C / 2             4,-2,5-7 = 4,-2,-2
 * (4,-2,-2)+ (5,1,1) = (9,-1,-1)    9                     9->A / 0             9-7,-1,-1 = 2,-1,-1
 * (2,-1,-1)+ (5,1,1) = (7,0,0)      7                     7->A / 0             7-7,0,0 = 0,0,0
 * (0,0,0)+ (5,1,1)...
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo009WeightSmoothRoundRobinLoadBalance implements LoadBalance {

    // 原始配置数据
    Map<String, Integer> ipWeightList = ServerInfo.IP_WEIGHTLIST_SMOOTH_ROUND_ROBIN;

    // 定义currentWeight，初始值为weightList
    Map<String, Integer> ipCurrentWeightList = new HashMap<>();

    @Override
    public String getServer() {

        // 权重求和
        int weightSum = ipWeightList.values().stream().mapToInt(a -> a).sum();

        // 初始化currentWeight
        if (ipCurrentWeightList.isEmpty()) {
            ipCurrentWeightList.putAll(ipWeightList);
        }

        // 选出有效权重当前这一次权重值最大的机器ip返回
        String resultIp = null;
        int currentWeightMax = 0;

        // 从currentWeight里选择出最大的权重值
        for (Map.Entry<String, Integer> ipCurrentWeight : ipCurrentWeightList.entrySet()) {

            // 选出权重最大值，权重值一样，按第一个进行选取，如果按后一个，此处则不是<，而是<=
            int currentWeight = ipCurrentWeight.getValue().intValue();
            if (currentWeightMax < currentWeight) {
                currentWeightMax = currentWeight;
                resultIp = ipCurrentWeight.getKey();
            }
        }

        // 修改当前权重值里最大的，减去配置权重纸盒：max(currentWeight) -= sum(weight)
        Integer resultIpWeight = ipCurrentWeightList.get(resultIp);
        ipCurrentWeightList.put(resultIp, resultIpWeight - weightSum);

        // 重新定义有效权重，有效权重的值+配置权重值，得到的结果为新的有效权重值：currentWeigh += weight
        for (Map.Entry<String, Integer> ipCurrentWeight : ipCurrentWeightList.entrySet()) {
            String ipCurrentWeightKey = ipCurrentWeight.getKey();
            Integer ipCurrentWeightValue = ipCurrentWeight.getValue();

            ipCurrentWeightList.put(ipCurrentWeightKey, ipCurrentWeightValue + ipWeightList.get(ipCurrentWeightKey));
        }

        return resultIp;
    }
}
