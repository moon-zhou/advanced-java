package org.moonzhou.practice.demo001producerconsumer;

import java.util.concurrent.TimeUnit;

/**
 * 消费者线程<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/4 21:44
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Consumer implements Runnable {

    // 消费者名称
    private String name;

    // 产品所属的仓库，从中获取值，实质是个队列
    private Storage storage;

    public Consumer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
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

        System.out.println(name + "消费者线程启动，3秒后开始消费");

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 每隔一百毫秒生产一个
        while (true) {
            Product product = storage.consume();
            System.out.println("已出库：" + product);

            storage.monitorBlockQueue();

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
