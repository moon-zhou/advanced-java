package org.moonzhou.jvm.stack;

import java.util.concurrent.TimeUnit;

/**
 * 无限创建线程，同时无限创建局部变量，但是未复现。无线创建线程时会在StackOverflowError之前触发OOM，暂时未能构造出StackOverflowError。
 * -Xss160k -Xms32m -Xmx32m: java.lang.StackOverflowError
 *
 * @author moon zhou
 */
public class Demo002ThreadStackOOM {

    public static void infiniteRun() throws InterruptedException {

        int threadCount = 0;
        while (true) {
            // new Thread(() -> {

                // try {
                    // TimeUnit.HOURS.sleep(1);
                    // TimeUnit.SECONDS.sleep(1);
                    int a = Integer.MAX_VALUE;
                    int b = Integer.MAX_VALUE;
                    int c = Integer.MAX_VALUE;
                    Double aa = Double.MAX_VALUE;
                    Double bb = Double.MAX_VALUE;
                    Double cc = Double.MAX_VALUE;
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }

            // }).start();

            System.out.println("do: " + threadCount++);
            // TimeUnit.MILLISECONDS.sleep(200);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        infiniteRun();
    }

}