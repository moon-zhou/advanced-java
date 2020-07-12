/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo010HashLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/12 18:18
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance.impl;

import org.moonzhou.practice.demo002loadbalance.LoadBalance;
import org.moonzhou.practice.demo002loadbalance.ServerInfo;

import java.util.List;

/**
 * 功能描述:哈希算法<br>
 *     简单hash，通过hash取模
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo010SimpleHashLoadBalance implements LoadBalance {

    String client;

    public Demo010SimpleHashLoadBalance(String client) {
        this.client = client;
    }

    @Override
    public String getServer() {
        List<String> ipWeightList = ServerInfo.IP_LIST;

        int hashCode = client.hashCode();

        int serverPos = hashCode % ipWeightList.size();

        return ipWeightList.get(serverPos);
    }
}
