package org.moonzhou.advancedprogramming.reference;

/**
 * 值传递之基本数据类型<br>
 * https://juejin.im/post/5ea10ca4518825736d27ae23
 *
 * @author moon-zhou
 * @date: 2020/4/24 19:27
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001PrimitiveType {

    public static void main(String[] args) {
        int age = 18;
        modify(age);
        System.out.println(age);
    }

    private static void modify(int age1) {
        age1 = 30;
    }
}
