package org.moonzhou.advancedprogramming.basis.string;

import java.util.regex.Pattern;

/**
 * String split 方法使用正则方表达式<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/6 19:16
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002StringSplitTest {

    public static void main(String[] args) {
//        testSquareBracketRegex();


        testPatternRegex();

    }

    private static void testSquareBracketRegex() {
        String ts = "竹杖芒鞋轻胜马.一蓑烟雨任平生";

        // 可以使用字符类 [] 来包含英文逗点“.”，它也是一个正则表达式，用来匹配方括号中包含的任意字符。
        if (ts.contains(".")) {
            String[] parts = ts.split("[.]");
            System.out.println("特殊字符.分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
        }
    }

    private static void testPatternRegex() {
        String ts = "竹杖芒鞋轻胜马.一蓑烟雨任平生";

        // 可以使用字符类 [] 来包含英文逗点“.”，它也是一个正则表达式，用来匹配方括号中包含的任意字符。
        if (ts.contains(".")) {
            String[] parts = ts.split(Pattern.quote("."));
            System.out.println("特殊字符.分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
        }
    }
}
