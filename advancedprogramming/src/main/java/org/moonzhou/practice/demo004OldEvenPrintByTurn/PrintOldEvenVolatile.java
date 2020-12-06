package org.moonzhou.practice.demo004OldEvenPrintByTurn;

import java.util.concurrent.TimeUnit;

public class PrintOldEvenVolatile implements IPrintOldEven {
    private static final int MAX_PRINT_NUM = 100;
    private static volatile int count = 0;

    @Override
    public void printByTurns() {

        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println("num:" + count);
                    count++;
                }
            }
        }).start();

        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println("num:" + count);
                    count++;
                }
            }
        }).start();
    }
}