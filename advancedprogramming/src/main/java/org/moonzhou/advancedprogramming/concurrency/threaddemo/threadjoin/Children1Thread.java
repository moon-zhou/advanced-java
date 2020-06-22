package org.moonzhou.advancedprogramming.concurrency.threaddemo.threadjoin;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/22 11:53
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Children1Thread extends Thread {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        System.out.println("in children1 thread...");

        System.out.println("start call grandson thread in children1 thread...");
        GrandsonThread grandsonThread = new GrandsonThread();
        grandsonThread.start();
        try {
            // grandson线程加入当前线程，即执行grandson线程时，当前方法所属线程会在这里等待，不继续往下执行（挂起状态）。
            grandsonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("grandson thread done in children1 thread...");

        try {
            TimeUnit.MILLISECONDS.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("children1 thread done...");
    }
}
