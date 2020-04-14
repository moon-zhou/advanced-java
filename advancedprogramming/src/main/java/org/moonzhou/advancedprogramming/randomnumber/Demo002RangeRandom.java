package org.moonzhou.advancedprogramming.randomnumber;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 某个范围的随机数生成<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/14 20:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002RangeRandom {
    public static void main(String[] args) {
        testRangeRandom1();

        testRangeRandom2();
    }

    private static void testRangeRandom1() {
        int leftLimit = 2;
        int rightLimit = 11;

        Random random = new Random();
        Runnable r = () -> {
            int generatedInteger = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
            System.out.println(generatedInteger);
        };

        for (int i = 1; i < 10; i++) {
            new Thread(r).start();
        }
    }

    private static void testRangeRandom2() {
        int leftLimit = 2;
        int rightLimit = 11;

        Runnable r = () -> {
            int generatedInteger = ThreadLocalRandom.current().nextInt(leftLimit, rightLimit + 1);
            System.out.println(generatedInteger);
        };
        for (int i = 1; i < 10; i++) {
            new Thread(r).start();
        }
    }
}
