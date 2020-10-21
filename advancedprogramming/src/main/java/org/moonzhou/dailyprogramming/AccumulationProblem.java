/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: AccumulationProblem.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/10/21 8:52
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

/**
 * 功能描述: 累加问题<br>
 *     底层的字节码层面分析暂时未进行，具体可参考：https://juejin.im/post/6885187698420613127?utm_source=gold_browser_extension
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AccumulationProblem {

    public static void main(String[] args) {
        errorTest();

        testNormal();

        testRight();
    }

    private static void errorTest() {
        int i = 3;
        i = i++;

        System.out.println(i);
    }

    private static void testNormal() {
        int i = 3;
        i++;

        System.out.println(i);
    }

    private static void testRight() {
        int i = 3;
        i = ++i;

        System.out.println(i);
    }
}
