package org.moonzhou.advancedprogramming.basis.string;

/**
 * String split 正则表达式里使用断言模式<br>
 * 一般使用是想分割后的字符串，包含被分割的字符
 *
 * @author moon-zhou
 * @date: 2020/5/6 19:36
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004StringSplitTest {

    public static void main(String[] args) {
        String cmower = "竹杖芒鞋轻胜马，一蓑烟雨任平生";
        if (cmower.contains("，")) {

            // ?<= 正向后行断言
            // ?= 正向先行断言
            // ?! 负向先行断言
            // ?<! 负向后行断言
            String[] parts = cmower.split("(?<=，)");
            System.out.println("第一部分：" + parts[0] + " 第二部分：" + parts[1]);
        }
    }
}
