package org.moonzhou.stringutils;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/13 19:55
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003StringSplit {

    public static void main(String[] args) {
        commonLang3Split();

        guavaSplit();
    }

    private static void commonLang3Split() {
        String[] result1 = StringUtils.split("a..b.c", '.');
        for (int i = 0; i < result1.length; i++) {
            System.out.println("split " + i + "  " + result1[i]);
        }

        String[] result2 = StringUtils.splitByWholeSeparatorPreserveAllTokens("a..b.c", ".");
        for (int i = 0; i < result2.length; i++) {
            System.out.println("split " + i + "  " + result2[i]);
        }
    }

    private static void guavaSplit() {
        Splitter splitter = Splitter.on(",");

        // 返回是一个 List 集合，结果：[ab, , b, c]
        System.out.println(splitter.splitToList("ab,,b,c"));

        // 忽略空字符串，输出结果 [ab, b, c]
        System.out.println(splitter.omitEmptyStrings().splitToList("ab,,b,c"));
    }
}
