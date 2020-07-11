/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: ServerInfo.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/1 19:18
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.practice.demo002loadbalance;

import java.util.*;

/**
 * 功能描述:服务器信息配置类<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ServerInfo {

    /**
     * 单纯的机器列表，无权重
     */
    public static final List<String> IP_LIST = Arrays.asList(
            "192.168.0.100",
            "192.168.0.101",
            "192.168.0.102",
            "192.168.0.103",
            "192.168.0.104",
            "192.168.0.105",
            "192.168.0.106",
            "192.168.0.107",
            "192.168.0.108",
            "192.168.0.109");

    /**
     * 带有权重配置的机器列表，为了更好便于测试，使用有序Map
     * key为机器ip，value为列表。
     */
    public static Map<String, Integer> IP_WEIGHTLIST = new LinkedHashMap<>();

    static {
        IP_WEIGHTLIST.put("192.168.0.100", 1);
        IP_WEIGHTLIST.put("192.168.0.101", 1);
        IP_WEIGHTLIST.put("192.168.0.102", 4);
        IP_WEIGHTLIST.put("192.168.0.103", 1);
        IP_WEIGHTLIST.put("192.168.0.104", 1);
        IP_WEIGHTLIST.put("192.168.0.105", 3);
        IP_WEIGHTLIST.put("192.168.0.106", 1);
        IP_WEIGHTLIST.put("192.168.0.107", 2);
        IP_WEIGHTLIST.put("192.168.0.108", 1);
        IP_WEIGHTLIST.put("192.168.0.109", 1);
    }

    /**
     * 带权重的ip配置，简化数据方便测试
     */
    public static Map<String, Integer> IP_WEIGHTLIST_LITTLE = new LinkedHashMap<>();

    static {
        IP_WEIGHTLIST_LITTLE.put("192.168.0.100", 3);
        IP_WEIGHTLIST_LITTLE.put("192.168.0.101", 4);
        IP_WEIGHTLIST_LITTLE.put("192.168.0.102", 3);
    }

}
