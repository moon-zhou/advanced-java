/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001CacheLineProof.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/8/16 11:43
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.cacheline;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 缓存行证明<br>
 * <p>
 * 通过二维数组的横向遍历和纵向遍历的耗时，来证明缓存行的存在
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001CacheLineProof {

    public static void main(String[] args) {
        int[][] array = new int[64 * 1024][1024];

        Stopwatch stopwatch = Stopwatch.createStarted();

        // 横向遍历
        for (int i = 0; i < 64 * 1024; i++)
            for (int j = 0; j < 1024; j++)
                array[i][j]++;

        System.out.println("横向遍历耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch.reset();
        stopwatch.start();

        // 纵向遍历
        for (int i = 0; i < 1024; i++)
            for (int j = 0; j < 64 * 1024; j++)
                array[j][i]++;

        System.out.println("纵向遍历耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
