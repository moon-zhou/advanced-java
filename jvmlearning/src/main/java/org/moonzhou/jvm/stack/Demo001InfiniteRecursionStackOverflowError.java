package org.moonzhou.jvm.stack;

/**
 * 无限递归：方法不断压入方法栈
 * -Xss256k: java.lang.StackOverflowError
 * @author moon zhou
 */
public class Demo001InfiniteRecursionStackOverflowError {
    static int i = 0;

    // Method to print numbers
    public static int printNumber(int x) {

        i = i + 2;
        System.out.println(i);
        return i + printNumber(i + 2);
    }

    public static void main(String[] args) {
        // Recursive call without any
        // terminating condition
        Demo001InfiniteRecursionStackOverflowError.printNumber(i);
    }
}