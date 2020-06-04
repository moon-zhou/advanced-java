package org.moonzhou.practice.demo001producerconsumer;

import java.util.concurrent.TimeUnit;

/**
 * 生产者对象<br>
 * 其实是个线程
 *
 * @author moon-zhou
 * @date 2020/6/4 21:40
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Producer implements Runnable {

    private String name;//生产者名称
    private String pname;//生产的产品

    // 生产者生产产品所存储的工厂，实质是队列
    private Storage storage;

    public Producer(String name, String pname, Storage storage) {
        this.name = name;
        this.pname = pname;
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

        System.out.println(name + "生产者线程启动，2秒后开始生产");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 每隔两百毫秒生产一个产品
        while (true) {

            Product p = new Product(pname, name);

            boolean result = storage.produce(p);

            System.out.println(p + "生产" + (result ? "成功" : "失败"));

            storage.monitorBlockQueue();

            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
