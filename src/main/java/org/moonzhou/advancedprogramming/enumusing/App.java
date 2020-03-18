package org.moonzhou.advancedprogramming.enumusing;

/**
 * 常规枚举功能测试类
 *
 * @author moon-zhou
 * @date: 2020/3/18 20:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class App {
    public static void main(String[] args) {
        // 测试枚举多属性
        System.out.println(MessageEnum.getMessageByCode("0000"));
        System.out.println(MessageEnum.getMessageByCode("0001"));
        System.out.println(MessageEnum.getMessageByCode("0002"));
    }
}
