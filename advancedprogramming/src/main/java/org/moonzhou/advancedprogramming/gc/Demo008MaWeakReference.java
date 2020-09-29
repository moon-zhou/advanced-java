/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo008MaWeakReference.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/9/29 19:21
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.gc;

import java.lang.ref.WeakReference;

/**
 * 功能描述: 弱引用的简单示例，与<code>org.moonzhou.advancedprogramming.gc.Demo006WeakReference</code>相比更易理解<br>
 *
 *   栈里，保存的是强引用WeakReference对象的地址                 堆里的强引用对象WeakReference，保存一个弱引用           堆里的object对象
 * |------------|                                           ___________                                          ·······
 * |            |  ——————————————强引用————————————————>    |          |··············弱引用··················>   |      |
 * |----------- |                                          |__________|                                          ·······
 *
 * GC后，直接释放弱引用所引用的对象
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo008MaWeakReference {
    public static void main(String[] args) {
        WeakReference<Object> objectWeakReference = new WeakReference<Object>(new Object());

        System.out.println(objectWeakReference.get());

        System.gc();

        System.out.println(objectWeakReference.get());
    }
}
