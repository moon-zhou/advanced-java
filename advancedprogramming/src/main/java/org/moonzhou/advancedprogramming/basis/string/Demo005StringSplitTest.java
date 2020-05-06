package org.moonzhou.advancedprogramming.basis.string;

/**
 * 多个相同分割符的情况<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/5/6 19:41
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo005StringSplitTest {

    public static void main(String[] args) {
        String cmower = "回首向来萧瑟处，归去，也无风雨也无晴。";
        if (cmower.contains("，")) {
            // 短路模式，达到的分割的限制后，后面的不再进行分割
            String[] parts = cmower.split("，", 2);
            System.out.println(parts.length);
            System.out.println("第一部分：" + parts[0] + " 第二部分：" + parts[1]);
        }
    }
}
