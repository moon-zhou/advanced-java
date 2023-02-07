package org.moonzhou.advancedprogramming.concurrency.delayqueue.demo001;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue队列是一个延迟队列，DelayQueue中存放的元素必须实现Delayed接口的元素，实现接口后相当于是每个元素都有个过期时间，当队列进行take获取元素时，先要判断元素有没有过期，只有过期的元素才能出队操作，没有过期的队列需要等待剩余过期时间才能进行出队操作。
 *
 * @author moon-zhou
 * @date: 2020/5/11 14:31
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Slf4j
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        Order Order1 = new Order("Order1", 5, TimeUnit.SECONDS);
        Order Order2 = new Order("Order2", 10, TimeUnit.SECONDS);
        Order Order3 = new Order("Order3", 15, TimeUnit.SECONDS);
        DelayQueue<Order> delayQueue = new DelayQueue<>();
        delayQueue.put(Order1);
        delayQueue.put(Order2);
        delayQueue.put(Order3);

        log.info("订单延迟队列开始时间: {}.", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        while (delayQueue.size() != 0) {
            /**
             * 取队列头部元素是否过期
             */
            Order task = delayQueue.poll();
            if (task != null) {
                log.info("订单:{}被取消, 取消时间:{}.", task.name, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            } else {
                log.info("no element!!!");
            }
            Thread.sleep(1000);
        }
    }
}
