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

        count();
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

    private static void count() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射关系
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新映射函数: 重新计算鞋加上10%的增值税后的价值
        int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + value * 10/100);
        System.out.println("Price of Shoes after VAT: " + shoesPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }
}
