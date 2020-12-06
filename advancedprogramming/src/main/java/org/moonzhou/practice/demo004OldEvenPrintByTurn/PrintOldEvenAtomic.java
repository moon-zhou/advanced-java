package org.moonzhou.practice.demo004OldEvenPrintByTurn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintOldEvenAtomic implements IPrintOldEven {
    // 打印何时结束需要设置一个上限，打印到100结束；
    private static final int MAX_PRINT_NUM = 100;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void printByTurns() {
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // 打印偶数.
                if (atomicInteger.get() % 2 == 0) {
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println("num:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();


                }
            }
        }).start();

        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                // 打印奇数.
                if (atomicInteger.get() % 2 == 1) {
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println("num:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();


                }
            }
        }).start();
    }
}