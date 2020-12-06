package org.moonzhou.practice.demo004OldEvenPrintByTurn;

import org.junit.Test;

/**
 * 不在主线程，看不出main方法的的打印效果
 */
public class PrintOldEvenTest {

    @Test
    public void testAtomic() {
        IPrintOldEven printOldEven = new PrintOldEvenAtomic();
        printOldEven.printByTurns();
    }

    @Test
    public void testVolatile() {
        IPrintOldEven printOldEven = new PrintOldEvenVolatile();
        printOldEven.printByTurns();
    }

    @Test
    public void testWatiNOtify() {
        IPrintOldEven printOldEven = new PrintOldEvenWaitNotify();
        printOldEven.printByTurns();
    }
}