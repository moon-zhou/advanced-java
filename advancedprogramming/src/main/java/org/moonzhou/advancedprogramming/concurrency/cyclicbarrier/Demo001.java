package org.moonzhou.advancedprogramming.concurrency.cyclicbarrier;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/18 15:28
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {
    public static void main(String[] args) {
        String[] heros = {"玩家1", "玩家2", "玩家3", "玩家4", "玩家5"};

        ExecutorService teammate = Executors.newFixedThreadPool(5);
        ExecutorService opponent = Executors.newFixedThreadPool(5);

        // 如果线程池的线程数量过少，就会发生死锁
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("人数到齐，准备加载游戏开始进度条...");
        });

        for (int i = 0; i < 5; i++) {
            teammate.execute(new Player("队友： " + heros[i], cyclicBarrier));
            opponent.execute(new Player("对手： " + heros[i], cyclicBarrier));
        }

        teammate.shutdown();
        opponent.shutdown();
    }
}

class Player implements Runnable {

    private final String hero;
    private final CyclicBarrier cyclicBarrier;

    public Player(String hero, CyclicBarrier cyclicBarrier) {
        this.hero = hero;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(1 + new RandomDataGenerator().nextInt(1, 3));
            System.out.println(hero + " 开始加载，等待其他玩加载成功");

            cyclicBarrier.await();

            System.out.println(hero + " 看到所有玩家加载成功，游戏开始");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
