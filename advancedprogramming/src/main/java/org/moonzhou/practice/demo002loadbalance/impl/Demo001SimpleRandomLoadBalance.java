/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001SimpleRandomLoadBalance.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/1 19:24
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

/**
 * 功能描述:简单随机负载均衡<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001SimpleRandomLoadBalance implements LoadBalance {
    @Override
    public String getServer() {

        List<String> ipList = ServerInfo.IP_LIST;

        Random random = new Random();

        // random随机数是不包含参数值的，范围为[0, num)，而List下标刚刚好为[0, length - 1]
        return ipList.get(random.nextInt(10));
    }
}
