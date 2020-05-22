package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/18 14:48
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo007ReentrantLockFairOrNot2 {
    private static Lock fireLock = new ReentrantLock(true);

    private static Lock unfireLock = new ReentrantLock();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        System.out.println("test fire lock.....................");

        CyclicBarrier barrier = new CyclicBarrier(100 + 1, () -> {
            System.out.println("barrier 结束.......");
        });

        ThreadPoolExecutor poolExe = new ThreadPoolExecutor(100, 1000, 1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(100));

        for (int i = 0; i < 100; i++) {
            poolExe.execute(new LockTest(barrier, fireLock));
        }

        // 为了先测试公平锁，然后在这里停住，等公平锁的例子都走完了，再往下执行非公平锁
        barrier.await();

        System.out.println("公平锁整体耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        barrier.reset();
        stopwatch.reset();
        stopwatch.start();

        System.out.println("test unFire lock....................");

        for (int i = 0; i < 100; i++) {
            poolExe.execute(new LockTest(barrier, unfireLock));
        }

        barrier.await();
        System.out.println("非公平锁整体耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        poolExe.shutdown();
        System.out.println("test finish......");
    }

    private static void tesFireLock() {
        fireLock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "获得锁");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fireLock.unlock();
        }
    }

    private static void testUnFireLock() {
        unfireLock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "获得锁");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unfireLock.unlock();
        }
    }

}

class LockTest implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final Lock fireLock;

    public LockTest(CyclicBarrier cyclicBarrier, Lock fireLock) {
        this.cyclicBarrier = cyclicBarrier;
        this.fireLock = fireLock;
    }

    @Override
    public void run() {

        fireLock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "获得锁");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fireLock.unlock();

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}