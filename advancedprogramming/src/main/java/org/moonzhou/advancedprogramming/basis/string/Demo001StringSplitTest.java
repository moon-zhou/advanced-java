package org.moonzhou.advancedprogramming.basis.string;

import java.util.ArrayList;
import java.util.List;

/**
 * String split 简单使用<br>
 * https://juejin.im/post/5eaa0e6ef265da7b9450b34b
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/30 16:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001StringSplitTest {
    public static void main(String[] args) {
        //test1();

        test2();
    }

    /**
     * split基本使用
     */
    private static void test1() {
        String cmower = "竹杖芒鞋轻胜马，一蓑烟雨任平生";
        if (cmower.contains("，")) {
            String[] parts = cmower.split("，");
            System.out.println("第一部分：" + parts[0] + "    第二部分：" + parts[1]);
        } else {
            throw new IllegalArgumentException("当前字符串没有包含逗号");
        }
    }

    /**
     * 测试需转译的字符串
     * 注意需要双反斜杠\\，因为反斜杠本身也需要转译
     */
    private static void test2() {
        List<String> contentList = new ArrayList<>();
        contentList.add("竹杖芒鞋轻胜马\\一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马^一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马$一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马.一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马|一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马?一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马*一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马+一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马(一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马)一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马()一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马[一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马]一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马[]一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马{一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马}一蓑烟雨任平生");
        contentList.add("竹杖芒鞋轻胜马{}一蓑烟雨任平生");

        contentList.forEach(content ->{
            if (content.contains("\\")) {
                // 需要进行转译，否则ArrayIndexOutOfBoundsException
                String[] parts = content.split("\\\\");
                System.out.println("特殊字符\\分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("^")) {
                // 需要进行转译，否则无法分割，按预期进行数组获取时，会出现ArrayIndexOutOfBoundsException，无法分割时数组为1，内容为原数组
                String[] parts = content.split("\\^");
                System.out.println("特殊字符^分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("$")) {
                // 需要进行转译，否则无法分割，按预期进行数组获取时，会出现ArrayIndexOutOfBoundsException，无法分割时数组为1，内容为原数组
                String[] parts = content.split("\\$");
                System.out.println("特殊字符$分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains(".")) {
                // 需要进行转译，否则无法分割，按预期进行数组获取时，会出现ArrayIndexOutOfBoundsException，长度为0
                String[] parts = content.split("\\.");
                System.out.println("特殊字符.分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("|")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\|");
                System.out.println("特殊字符|分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("?")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\?");
                System.out.println("特殊字符?分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("*")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\*");
                System.out.println("特殊字符*分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("+")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\+");
                System.out.println("特殊字符+分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("(")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\(");
                System.out.println("特殊字符(分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains(")")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\)");
                System.out.println("特殊字符)分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("()")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\(\\)");
                System.out.println("特殊字符()分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("[")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\[");
                System.out.println("特殊字符[分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("]")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\]");
                System.out.println("特殊字符]分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("[]")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\[\\]");
                System.out.println("特殊字符[]分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("{")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\{");
                System.out.println("特殊字符{分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("}")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\}");
                System.out.println("特殊字符}分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

            if (content.contains("{}")) {
                // 需要进行转译，否则PatternSyntaxException，IDEA里编译报错
                String[] parts = content.split("\\{\\}");
                System.out.println("特殊字符{}分割" + "第一部分：" + parts[0] + "    第二部分：" + parts[1]);
            }

        });
    }
}
