package org.moonzhou.advancedprogramming.util;

import org.slf4j.helpers.MessageFormatter;

/**
 * @author moon zhou
 * @version 1.0
 * @description: String.format使用的占位符比如<code>%s</code>极其不明显
 * @date 2023/6/2 17:58
 */
public class StringFormatUtil {

    public static void main(String[] args) {
        System.out.println(String.format("hello %s", "world"));

        System.out.println(MessageFormatter.format("Hi {}.", "there").getMessage());

        System.out.println(format("{} is {}", "moon", "handsome"));

    }

    /**
     * @param format
     * @param args
     * @return
     */
    public static String format(String format, Object... args) {
        return MessageFormatter.arrayFormat(format, args).getMessage();
    }
}
