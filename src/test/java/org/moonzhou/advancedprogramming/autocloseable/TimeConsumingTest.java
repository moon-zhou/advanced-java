package org.moonzhou.advancedprogramming.autocloseable;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/3/23 08:53
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TimeConsumingTest {
    public static void testPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println("now " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testPrintRuntimeException() {
        for (int i = 0; i < 5; i++) {
            System.out.println("now " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 3) {
                throw new RuntimeException("runtime exception!");
            }
        }
    }

    @Test
    public void test() throws Exception {
        try (TimeConsuming c = new TimeConsuming()) {
            testPrint();
        }

        System.out.println("------over-------");
    }

    @Test
    public void testRuntimeException() throws Exception {
        try (TimeConsuming c = new TimeConsuming()) {
            testPrintRuntimeException();
        }

        System.out.println("------over-------");
    }
}