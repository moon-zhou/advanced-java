/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: MapTest.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/12 15:30
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:HashMap基本使用<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapTest {

    public static void main(String[] args) {
        testPutAll();
    }

    private static void testPutAll() {
        Map<String, Integer> src = new HashMap<>();
        src.put("A", new Integer(1));
        src.put("B", new Integer(2));
        src.put("C", new Integer(3));

        Map<String, Integer> dest = new HashMap<>();
        dest.putAll(src);

        System.out.println("pre src...");
        System.out.println(src);

        System.out.println("pre dest...");
        System.out.println(dest);

        src.put("A", new Integer(111));

        dest.put("A", new Integer(100));

        System.out.println("after src...");
        System.out.println(src);

        System.out.println("after dest...");
        System.out.println(dest);
    }
}
