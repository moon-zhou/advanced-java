package org.moonzhou.dailyprogramming.valuerefrence;

import java.util.Arrays;

/**
 * @author moon zhou
 * @description 值类型传递：string类型作为形参，只是在子方法里拷贝了实参的内容
 * @email ayimin1989@163.com
 * @date 2022/4/24 09:37
 **/
public class Demo002String {
    private static final String BEFORE_ADDRESS_FORMAT = "before 内存地址: %s";
    private static final String CHANGE_ADDRESS_FORMAT = "change 内存地址: %s";
    private static final String AFTER_ADDRESS_FORMAT = "after 内存地址: %s";

    private static final String BEFORE_OUT_FORMAT = "befor内容:------------- hello: %s";
    private static final String CHANGE_OUT_FORMAT = "形参内容：change:------------- hello: %s";
    private static final String AFTER_OUT_FORMAT = "实参内容：after:------------- hello: %s";

    public static void main(String[] args) {
        String hello = "hello moon";

        System.out.println(String.format(BEFORE_ADDRESS_FORMAT, System.identityHashCode(hello)));
        System.out.println(String.format(BEFORE_OUT_FORMAT, hello));

        change(hello);

        System.out.println(String.format(AFTER_ADDRESS_FORMAT, System.identityHashCode(hello)));
        System.out.println(String.format(AFTER_OUT_FORMAT, hello));
    }

    private static void change(String hello) {
        // 只是改变了形参的值
        hello = hello.substring(6);

        System.out.println(String.format(CHANGE_ADDRESS_FORMAT, System.identityHashCode(hello)));
        System.out.println(String.format(CHANGE_OUT_FORMAT, hello));
    }
}
