/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: BloomFilterCase.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/14 22:05
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 功能描述: 布隆过滤器示例<br>
 *
 *     参考：https://juejin.im/post/6882550443860459528
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BloomFilterCase {
    /**
     * 预计要插入多少数据
     */
    private static int size = 1000000;

    /**
     * 期望的误判率
     */
    private static double fpp = 0.01;

    /**
     * 布隆过滤器
     */
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {
        // 插入10万样本数据
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        // 用另外十万测试数据，测试误判率
        int count = 0;
        for (int i = size; i < size + 100000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("总共的误判数:" + count);
    }
}
