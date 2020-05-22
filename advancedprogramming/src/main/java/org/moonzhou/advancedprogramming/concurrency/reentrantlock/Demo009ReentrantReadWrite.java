package org.moonzhou.advancedprogramming.concurrency.reentrantlock;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 重入锁-重入读写锁<br>
 * 针对
 *
 * @author moon-zhou
 * @date 2020/5/19 12:05
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo009ReentrantReadWrite {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static int value;

    public static Object handRead(Lock lock) {
        try {
            lock.lock();

            // 模拟程序运行，执行耗时
            TimeUnit.MILLISECONDS.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "读操作：" + value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return value;
    }

    public static void handWrite(Lock lock, int index) {
        try {
            lock.lock();

            // 模拟程序运行，执行耗时
            TimeUnit.MILLISECONDS.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "写操作：" + value);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void testReadLock() {
        final int THREAD_COUNT = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
//        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT + 1);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(() -> {
                try {
                    // 业务代码
                    Demo009ReentrantReadWrite.handRead(readLock);

                    cyclicBarrier.await();
                } catch (Throwable e) {
                    e.printStackTrace();
                } /*finally {
                    latch.countDown();
                }*/
            });
        }

        try {
//            latch.await();
            cyclicBarrier.await();

            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void testWriteLock() {
        final int THREAD_COUNT = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
//        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT + 1);

        for (int i = 0; i < THREAD_COUNT; i++) {

            final int index = i;
            executorService.execute(() -> {
                try {
                    // 业务代码
                    Demo009ReentrantReadWrite.handWrite(writeLock, index);

                    cyclicBarrier.await();
                } catch (Throwable e) {
                    e.printStackTrace();
                }/* finally {
                    latch.countDown();
                }*/
            });
        }

        try {
//            latch.await();

            cyclicBarrier.await();

            executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void testReadWriteLock() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        CyclicBarrier runTimeCycBar = new CyclicBarrier(3);

        /**
         * testReadLock(runTimeCycBar) 和 testWriteLock(runTimeCycBar)这样是不行的，
         * 因为屏障必须是不同的线程之间设置，如果屏障在主线程，且await没有到0，则会导致当前主线程死锁
         */

        new Thread(()->{
            testReadLock();

            try {
                runTimeCycBar.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            testWriteLock();

            try {
                runTimeCycBar.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


        try {
            System.out.println("读写锁测试，等待执行结果");
            runTimeCycBar.await();

            System.out.println("读写锁整体耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void testReadWriteLock2() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        CyclicBarrier runTimeCycBar = new CyclicBarrier(41);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    Demo009ReentrantReadWrite.handRead(readLock);

                    runTimeCycBar.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    Demo009ReentrantReadWrite.handWrite(writeLock, new Random().nextInt(100));

                    runTimeCycBar.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            runTimeCycBar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("读写锁整体耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    private static void testLock2() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        CyclicBarrier runTimeCycBar = new CyclicBarrier(41);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    Demo009ReentrantReadWrite.handRead(lock);

                    runTimeCycBar.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    Demo009ReentrantReadWrite.handWrite(lock, new Random().nextInt(100));

                    runTimeCycBar.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            runTimeCycBar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("非公平重入锁锁整体耗时：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }


    public static void main(String[] args) {
        testReadWriteLock();

//        testReadWriteLock2();

//        testLock2();
    }
}
