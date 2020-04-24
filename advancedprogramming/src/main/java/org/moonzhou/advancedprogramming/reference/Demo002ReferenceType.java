package org.moonzhou.advancedprogramming.reference;

/**
 * 引用类型传递<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/24 19:29
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002ReferenceType {
    public static void main(String[] args) {
        Writer a = new Writer(18);
        Writer b = new Writer(18);
        modify(a, b);

        System.out.println(a.getAge());
        System.out.println(b.getAge());
    }

    private static void modify(Writer a1, Writer b1) {
        a1.setAge(30);

        b1 = new Writer(18);
        b1.setAge(30);
    }

}

class Writer {
    private int age;

    public Writer(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}