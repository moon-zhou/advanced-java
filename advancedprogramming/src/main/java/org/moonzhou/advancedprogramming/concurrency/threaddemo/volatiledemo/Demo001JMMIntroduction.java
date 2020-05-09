package org.moonzhou.advancedprogramming.concurrency.threaddemo.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * volatile学习 引入JMM<br>
 * https://juejin.im/post/5ea913d35188256d4576d199
 *
 * @author moon-zhou
 * @date: 2020/5/9 17:20
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001JMMIntroduction {

    public static void main(String[] args) {
        Aobing aobing = new Aobing();
        aobing.start();

        for (; ; ) {
            // never run, because JMM
            if (aobing.isFlag()) {
                System.out.println("hello...");
            }
        }
    }
}

class Aobing extends Thread {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag=" + flag);
    }

}