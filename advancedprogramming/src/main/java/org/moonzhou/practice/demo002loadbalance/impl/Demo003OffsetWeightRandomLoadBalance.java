/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo003OffsetWeightRandomLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/7 10:47
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

/**
 * 功能描述:使用偏移的方式，来进行随机权重算法，随机值为[0,num)，因此算法里的服务器选择索引时，必须从0开始<br>
 *     总权重10，随机值[0,10)，更抽象一点为[0,权重之和)，分别对应的机器权重配置如下：A:3    B:4    C:3
 *     如果随机到2，则是2-3<0，选择A
 *     如果随机到3，则是3-3=0，选择B
 *     如果随机到5，则是5-3=2>0，此时排除A，权重配置整体偏移3，权重剩余2（5-3），2-4=-2<0，选择B
 *     如果随机到7，则是7-3=4>0，4-4=0，排除A，B，选择C。
 *     如果随机到9，则是9-3=6>0，6-4=2>0，2-3=-1<0，存在C
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003OffsetWeightRandomLoadBalance implements LoadBalance {

    @Override
    public String getServer() {

        int weightSum = 0;

        Map<String, Integer> ipWeightList = ServerInfo.IP_WEIGHTLIST;
        for (Map.Entry<String, Integer> ipWeight : ipWeightList.entrySet()) {
            weightSum += ipWeight.getValue();
        }

        Random random = new Random();
        int offset = random.nextInt(weightSum);
        System.out.println("===================" + offset);
        for (Map.Entry<String, Integer> ipWeight : ipWeightList.entrySet()) {
            if (offset - ipWeight.getValue() < 0) {
                return ipWeight.getKey();
            }

            offset -= ipWeight.getValue();
        }

        // 此处可以给默认值
        return null;
    }
}
