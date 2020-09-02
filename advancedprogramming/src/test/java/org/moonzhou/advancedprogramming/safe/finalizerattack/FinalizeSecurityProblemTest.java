package org.moonzhou.advancedprogramming.safe.finalizerattack;


import org.junit.Test;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem.SensitiveOperation;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem.SensitiveOperationFinalizer;

import java.util.concurrent.TimeUnit;

public class FinalizeSecurityProblemTest {

    @Test
    public void testNormalException() {
        // 实例化抛出异常，无法调用具体的方法
        SensitiveOperation sensitiveOperation = new SensitiveOperation();
        sensitiveOperation.storeMoney();
    }

    @Test
    public void testNoException() {
        try {
            // 实例化子类的时候，依然会调用父类的实例化方法，抛出异常，直接进入catch
            SensitiveOperation sensitiveOperation = new SensitiveOperationFinalizer();

            System.out.println("do store money directly start...");
            sensitiveOperation.storeMoney();
            System.out.println("do store money directly end...");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

        //
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}