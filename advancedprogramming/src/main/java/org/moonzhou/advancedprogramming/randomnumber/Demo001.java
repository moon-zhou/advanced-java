package org.moonzhou.advancedprogramming.randomnumber;

import java.util.Random;

/**
 * 随机数示例<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/14 19:51
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {

        testMathRandom();

        testRandom();
    }

    private static void testMathRandom() {
        System.out.println("test Math.random:");

        Runnable runnable = () -> {
            System.out.println(Math.random());
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

    private static void testRandom() {
        System.out.println("test Random:");

        Random random = new Random();

        Runnable runnable = () -> {
            System.out.println(random.nextInt(20));
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
