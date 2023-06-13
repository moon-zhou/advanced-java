package org.moonzhou.dailyprogramming.lambda.snippet.functioninterface;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 09:54
 */
public class TestMyInterface {
    public static void main(String[] args) {
        testNormal();

        testLambda();
    }

    private static void testNormal() {
        MyInterface myObject = new MyInterface() {
            @Override
            public void doSomething(String input) {
                System.out.println(input);
            }
        };
        myObject.doSomething("Hello World");
    }

    private static void testLambda() {
        // MyInterface myObject = input -> System.out.println(input);
        MyInterface myObject = System.out::println;
        myObject.doSomething("Hello World");
    }
}
