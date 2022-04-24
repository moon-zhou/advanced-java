package org.moonzhou.dailyprogramming.valuerefrence;

import java.util.Arrays;

/**
 * @author moon zhou
 * @description 值类型传递：数组类型（引用）,如果改变形参的地址值，仅仅在子方法里有用，实际的值在主方法不受影响，如果想改变主方法里的实参的值，只能通过实参的地址，改变其内容。
 * @email ayimin1989@163.com
 * @date 2022/4/24 09:55
 **/
public class Demo004Array {

    private static final String BEFORE_ADDRESS_FORMAT = "before 实参地址: %s";
    private static final String CHANGE_ADDRESS_FORMAT = "change 形参地址: %s";
    private static final String AFTER_ADDRESS_FORMAT = "after 实参地址: %s";

    private static final String BEFORE_OUT_FORMAT = "befor内容:------------- arr: ";
    private static final String CHANGE_OUT_FORMAT = "形参内容：change:------------- arr: ";
    private static final String AFTER_OUT_FORMAT = "实参内容：after:------------- arr: ";

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(String.format(BEFORE_ADDRESS_FORMAT, arr.toString()));
        System.out.println(BEFORE_OUT_FORMAT + Arrays.toString(arr));

        change(arr);

        System.out.println(String.format(AFTER_ADDRESS_FORMAT, arr.toString()));
        System.out.println(AFTER_OUT_FORMAT + Arrays.toString(arr));
    }

    private static void change(int[] array) {
        // 形参，通过源地址的引用，直接修改源对象的具体值，可以生效
        System.out.println("形参：" + array[0]);
        array[0] = 0;

        System.out.println();
        System.out.println(String.format(CHANGE_ADDRESS_FORMAT, array.toString()));
        System.out.println(CHANGE_OUT_FORMAT + Arrays.toString(array));

        // 形参，局部方法的地址值，不会影响主方法
        int[] temArray = {6, 6, 6};
        array = temArray;

        System.out.println("temp: " + String.format(CHANGE_ADDRESS_FORMAT, array.toString()));
        System.out.println("temp: " + CHANGE_OUT_FORMAT + Arrays.toString(array));
        System.out.println();
    }
}
