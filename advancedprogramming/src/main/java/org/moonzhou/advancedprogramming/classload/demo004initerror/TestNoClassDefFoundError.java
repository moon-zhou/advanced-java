package org.moonzhou.advancedprogramming.classload.demo004initerror;

import lombok.extern.slf4j.Slf4j;

/**
 * 第二次及以后使用到ClassWithInitErrors类的地方，都只会抛出NoClassDefFoundError错误，
 * 而且通常我们查看日志的时候，都会先看最新的日志，所以就不容易找到加载类失败的真正原因，
 * 对于这种情况，我们应该搜索java.lang.ExceptionInInitializerError错误，找到第一次加载类的时候的日志，才能看到失败的原因。
 * @author moon zhou
 */
@Slf4j
public class TestNoClassDefFoundError {
    private static final String SPLIT_LINE = "\n-----------------------------------------------------\n";

    public static void main(String[] args) throws InterruptedException {
        TestNoClassDefFoundError sample = new TestNoClassDefFoundError();
        sample.getClassWithInitErrors();
    }

    private void getClassWithInitErrors() throws InterruptedException {
        log.info("1st new");
        Thread.sleep(500);
        try {
            // 第一次new ClassWithInitErrors类，JVM会加载该类，初始化该类的静态变量或执行静态块
            new ClassWithInitErrors();
        } catch (Throwable t) {
            // 因为初始化静态变量失败，所以加载类失败。
            log.error("1st new error: ", t);
        }

        Thread.sleep(500);
        log.info(SPLIT_LINE);
        log.info("2nd new");
        Thread.sleep(500);
        try {
            // 第二次new ClassWithInitErrors类，JVM不会再加载该类，而是抛出NoClassDefFoundError异常
            new ClassWithInitErrors();
        } catch (Throwable t) {
            log.error("2nd new error: ", t);
        }

        Thread.sleep(500);
        log.info(SPLIT_LINE);
        log.info("3rd new");
        Thread.sleep(500);
        try {
            // 第三次new ClassWithInitErrors类，JVM不会再加载该类，而是抛出NoClassDefFoundError异常
            new ClassWithInitErrors();
        } catch (Throwable t) {
            log.error("3rd new error: ", t);
        }
    }
}