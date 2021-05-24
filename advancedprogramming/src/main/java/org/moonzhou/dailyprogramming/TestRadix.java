/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: TestRadix.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/5/21 16:54
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.dailyprogramming;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestRadix {
    public static void main(String[] args) {

        String s1 = "000111111111111";
        String s2 = "111111100000011";


        Integer csiRule = Integer.parseInt(s1, 2);
        Integer main = Integer.parseInt(s2, 2);
        System.out.println(fixLengthBins(csiRule));
        System.out.println(fixLengthBins(main));

        Integer result = csiRule & main;

        System.out.println(fixLengthBins(result));
    }

    static char[] fixLengthBins(Integer result) {

        String resultStr = Integer.toBinaryString(result);

        StringBuilder bins = new StringBuilder(resultStr);

        int len = bins.length();

        for (int i = 0; i < 15 - len; i++) {
            bins.insert(0, '0');
        }

        return bins.toString().toCharArray();
    }
}
