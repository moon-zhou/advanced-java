package org.moonzhou.dailyprogramming.valuerefrence;

/**
 * @author moon zhou
 * @description 值类型传递：基本数据类型，子方法里面的值做了替换，但是不影响父方法里的值。涉及到方法栈对于对于变量内存分配的处理。
 * @email ayimin1989@163.com
 * @date 2022/4/24 09:37
 **/
public class Demo001Primitive {
    private static final String BEFORE_OUT_FORMAT = "before:------------- num1: %d, num2: %d";
    private static final String SWAP_OUT_FORMAT = "形参：swap:------------- num1: %d, num2: %d";
    private static final String AFTER_OUT_FORMAT = "实参：after:------------- num1: %d, num2: %d";

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        System.out.println(String.format(BEFORE_OUT_FORMAT, num1, num2));

        swap(num1, num2);

        System.out.println(String.format(AFTER_OUT_FORMAT, num1, num2));
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println(String.format(SWAP_OUT_FORMAT, a, b));
    }
}
