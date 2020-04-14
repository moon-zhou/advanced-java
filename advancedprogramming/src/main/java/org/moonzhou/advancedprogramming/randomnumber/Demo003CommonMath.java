package org.moonzhou.advancedprogramming.randomnumber;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * common-math使用<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/14 20:16
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo003CommonMath {
    public static void main(String[] args) {
        int leftLimit = 2;
        int rightLimit = 11;

        Runnable r = () -> {
            int generatedInteger = new RandomDataGenerator().nextInt(leftLimit, rightLimit);
            System.out.println(generatedInteger);
        };
        for (int i = 1; i < 10; i++) {
            new Thread(r).start();
        }
    }
}
