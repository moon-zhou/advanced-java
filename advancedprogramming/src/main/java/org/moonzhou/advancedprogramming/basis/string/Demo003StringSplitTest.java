package org.moonzhou.advancedprogramming.basis.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用Pattern 类的 split方法，因为String的split的方法也是调用该方法进行的处理<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/6 19:25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003StringSplitTest {
    /**
     * 使用预编译功能，提高效率
     */
    private static Pattern twoPartSimple = Pattern.compile("\\.");

    /**
     * 意味着可以把字符串按照英文逗点拆分成一个字符组
     */
    private static Pattern twoPartComplex = Pattern.compile("(.+)\\.(.+)");

    public static void main(String[] args) {
        testSimplePattern();

        System.out.println("-------------");

        testComplexPattern();
    }

    private static void testSimplePattern() {
        String[] parts = twoPartSimple.split("竹杖芒鞋轻胜马.一蓑烟雨任平生");
        System.out.println("第一部分：" + parts[0] + " 第二部分：" + parts[1]);
    }

    private static void testComplexPattern() {
        checkString("竹杖芒鞋轻胜马.一蓑烟雨任平生");
        checkString("竹杖芒鞋轻胜马.");
        checkString(".一蓑烟雨任平生");
    }

    private static void checkString(String str) {
        Matcher m = twoPartComplex.matcher(str);
        if (m.matches()) {
            System.out.println("第一部分：" + m.group(1) + " 第二部分：" + m.group(2));
        } else {
            System.out.println("不匹配");
        }
    }
}
