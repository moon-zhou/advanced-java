package org.moonzhou.dailyprogramming.lambda.snippet;

import lombok.extern.slf4j.Slf4j;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/6/13 13:04
 */
@Slf4j
public class CreateThread {
    public static void main(String[] args) {
        jdkThread();

        lambdaThread();
    }

    private static void jdkThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("JDK Thread is running.");
            }
        });
        thread.start();
    }

    private static void lambdaThread() {
        Thread thread = new Thread(() -> log.info("Lambda Thread is running."));
        thread.start();
    }
}
