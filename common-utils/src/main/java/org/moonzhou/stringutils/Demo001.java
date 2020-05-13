package org.moonzhou.stringutils;

import org.apache.commons.lang3.StringUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/13 19:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {

    public static void main(String[] args) {

        // 字符串固定长度 8位，若不足，忘左补 0
        System.out.println(StringUtils.leftPad("test", 8, "0"));
        System.out.println(StringUtils.rightPad("test", 8, "0"));

        // 字符串替换
        // 默认替换所有关键字
        System.out.println(StringUtils.replace("aba", "a", "z"));
        // 替换关键字，仅替换一次
        System.out.println(StringUtils.replaceOnce("aba", "a", "z"));
        // 使用正则表达式替换
        System.out.println(StringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", ""));

    }
}
