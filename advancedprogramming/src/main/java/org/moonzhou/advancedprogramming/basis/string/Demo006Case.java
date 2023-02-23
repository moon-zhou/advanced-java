package org.moonzhou.advancedprogramming.basis.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

/**
 * @description:
 * 在使用不带区域设置的 java.lang.String.toUpperCase() 时，它将使用默认区域设置的规则。
 * 使用土耳其区域设置 "title".toUpperCase() 时将返回“T\u0130TLE”，其中“\u0130”是“LATIN CAPITAL LETTER I WITH DOT ABOVE”字符。
 * 这可能会导致意外的结果，例如在Example 1 中，这会阻止此验证捕获“script”一词，从而导致 Cross-Site Scripting 漏洞。
 *
 * @author moon zhou
 * @date 2023/2/23 10:06
 * @version 1.0
 */
@Slf4j
public class Demo006Case {
    public static void main(String[] args) {
        log.info("test default locale: ");
        defaultLocale();

        log.info("no time zone, using default: ");
        normalWithoutTimeZone();

        log.error("Simulate Turkey region, result is error: ");
        exceptionWithTimeZone();

        log.info("with custom Locale: ");
        withTimeZone(Locale.ENGLISH);
        withTimeZone(Locale.CHINA);
        withTimeZone(Locale.CHINESE);
    }

    private static void defaultLocale() {
        log.info("default locale: {}", Locale.getDefault());
    }

    private static void normalWithoutTimeZone() {
        String test = "aaaBBBccc";
        log.info(test.toUpperCase());

        test = "script";
        String testUpperCase = test.toUpperCase();
        log.info("upper case is: {}, equal result is: {}.", testUpperCase, testUpperCase.equals("SCRIPT"));
    }

    private static void exceptionWithTimeZone() {
        Locale turkey = new Locale("tr", "TR");

        String test = "script";
        String testUpperCase = test.toUpperCase(turkey);
        log.info("upper case is: {}, equal result is: {}.", testUpperCase, testUpperCase.equals("SCRIPT"));
    }

    private static void withTimeZone(Locale locale) {
        String test = "script";
        String testUpperCase = test.toUpperCase(locale);
        log.info("upper case is: {}, equal result is: {}.", testUpperCase, testUpperCase.equals("SCRIPT"));
    }
}
