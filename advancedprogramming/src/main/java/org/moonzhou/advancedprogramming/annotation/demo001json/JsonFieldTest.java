package org.moonzhou.advancedprogramming.annotation.demo001json;

/**
 * 自定义注解使用测试类<br>
 * https://juejin.im/post/5e911eca6fb9a03c485777d6
 *
 * @author moon-zhou
 * @date: 2020/4/13 17:57
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JsonFieldTest {
    public static void main(String[] args) throws IllegalAccessException {
        Writer moon = new Writer(18, "moon-zhou", "javaer");
        System.out.println(JsonSerializer.serialize(moon));

        System.out.println();

        Writer moon1 = new Writer(18, "moon-zhou", null);
        System.out.println(JsonSerializer.serialize(moon1));
    }
}
