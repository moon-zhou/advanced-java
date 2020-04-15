package org.moonzhou.advancedprogramming.concurrency.countdownlatch.Demo002CountLatchTransfer;

import java.util.concurrent.CountDownLatch;

/**
 * 包含CountDownLatch的并发线程<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date: 2020/4/15 19:24
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CountRunnable implements Runnable {

    private CountDownLatch countDownLatch;

    public CountRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

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
        try {
            synchronized (countDownLatch) {
                countDownLatch.countDown();

                System.out.println("线程执行 start：" + Thread.currentThread().getName());
                System.out.println("thread counts = " + (countDownLatch.getCount()));
            }

            countDownLatch.await();

            System.out.println("线程执行 end：" + Thread.currentThread().getName());
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
