package org.moonzhou.practice.demo001producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/6/4 22:14
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer1 = new Producer("生产者1", "小米手机", storage);
        Producer producer2 = new Producer("生产者2", "华为手机", storage);

        Consumer consumer = new Consumer("消费者1", storage);

        ExecutorService producerPool = Executors.newCachedThreadPool();
        producerPool.submit(producer1);
        producerPool.submit(producer2);


        ExecutorService consumerPool = Executors.newCachedThreadPool();
        consumerPool.submit(consumer);

    }
}
