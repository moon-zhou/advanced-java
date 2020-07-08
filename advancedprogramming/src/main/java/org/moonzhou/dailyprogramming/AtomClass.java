/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: AtomClass.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/8 15:42
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:基本类型原子包装类<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AtomClass {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.incrementAndGet());

        atomicInteger.set(0);
        System.out.println(atomicInteger.getAndIncrement());
    }
}
