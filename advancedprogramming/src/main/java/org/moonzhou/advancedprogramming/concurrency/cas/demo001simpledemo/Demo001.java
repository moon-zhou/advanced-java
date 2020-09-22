/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/21 18:02
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.concurrency.cas.demo001simpledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述: CAS使用小例子<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        Boolean result1 = atomicInteger.compareAndSet(10, 20);
        System.out.printf("当前atomicInteger变量的值:%d 比较结果%s\r\n", atomicInteger.get(), result1);
        Boolean result2 = atomicInteger.compareAndSet(10, 30);
        System.out.printf("当前atomicInteger变量的值:%d, 比较结果%s\n", atomicInteger.get(), result2);
    }

}
