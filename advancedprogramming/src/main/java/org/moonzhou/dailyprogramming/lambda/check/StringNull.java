package org.moonzhou.dailyprogramming.lambda.check;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 16:29
 */
@Slf4j
public class StringNull {
    public static void main(String[] args) {
        jdkCheck();

        lambdaCheck();
    }

    private static void jdkCheck() {
        String str = "Hello World";
        if (str != null) {
            log.info(str.toUpperCase());
        }
    }

    private static void lambdaCheck() {
        Optional<String> str = Optional.ofNullable("Hello World");
        str.map(String::toUpperCase).ifPresent(log::info);
    }
}
