package org.moonzhou.advancedprogramming.concurrency.threaddemo.threadjoin;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/22 11:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GrandsonThread extends Thread {

    @Override
    public void run() {
        System.out.println("in GrandsonThread thread...");

        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("GrandsonThread thread done...");
    }
}
