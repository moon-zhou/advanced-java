package org.moonzhou.advancedprogramming.randomnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

//        testMathRandom();

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

        // 并发安全
        final Set<Integer> randomInt = ConcurrentHashMap.newKeySet();

        Runnable runnable = () -> {
            // [0,num)的int类型的整数,包括0不包括num
            // System.out.println(random.nextInt(20));

            randomInt.add(random.nextInt(20));
        };

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (999 == i) {
                System.out.println("loop done...");
            }
        }

        System.out.println(randomInt);
    }
}
