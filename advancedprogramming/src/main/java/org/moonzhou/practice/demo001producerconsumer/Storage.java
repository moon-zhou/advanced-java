package org.moonzhou.practice.demo001producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 仓库，用于存储生产的产品，供消费者从此获取进行消费<br>
 *
 * @author moon-zhou
 * @date 2020/6/4 21:42
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Storage {

    // 阻塞队列，用于存储生产者生产的产品，供消费者进行消费
    private BlockingQueue<Product> storage = new LinkedBlockingDeque<>(16);

    /**
     * 生产产品，成功返回true，否则返回false
     *
     * @param product
     * @return
     */
    public boolean produce(Product product) {
        try {
            // 阻塞入库
            storage.put(product);

            System.out.println("货物入库：" + product);

            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 进行消费
     *
     * @return
     */
    public Product consume() {
        try {
            // 阻塞出库
            Product product = storage.take();

            System.out.println("货物出库：" + product);

            return product;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void monitorBlockQueue() {
        System.out.println("现有库存：" + storage.size());
    }
}
