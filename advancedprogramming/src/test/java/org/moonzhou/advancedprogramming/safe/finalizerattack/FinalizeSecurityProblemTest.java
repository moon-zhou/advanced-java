package org.moonzhou.advancedprogramming.safe.finalizerattack;


import org.junit.Test;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem.SensitiveOperation;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem.SensitiveOperationFinalizer;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo004logic2fix.SensitiveOperationFlag;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo004logic2fix.SensitiveOperationFlagFinalizer;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo005jdkadvancedfeature2fix.SensitiveOperationThis;
import org.moonzhou.advancedprogramming.safe.finalizerattack.demo005jdkadvancedfeature2fix.SensitiveOperationThisFinalizer;

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
//            SensitiveOperation sensitiveOperation = new SensitiveOperationFinalizer();
            SensitiveOperationFinalizer sensitiveOperation = new SensitiveOperationFinalizer();

            System.out.println("do store money directly start...");
            sensitiveOperation.storeMoney();
            System.out.println("do store money directly end...");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

        // gc，触发finalize
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogic2Fix() {

        try {
            // 实例化，抛出异常，直接进入catch
            SensitiveOperationFlag sensitiveOperationFlag = new SensitiveOperationFlagFinalizer();

            System.out.println("do store money directly start...");
            sensitiveOperationFlag.storeMoney();
            System.out.println("do store money directly end...");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

        // gc，触发finalize
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThis2Fix() {
        try {
            // 实例化，抛出异常，直接进入catch
            SensitiveOperationThis sensitiveOperationFlag = new SensitiveOperationThisFinalizer();

            System.out.println("do store money directly start...");
            sensitiveOperationFlag.storeMoney();
            System.out.println("do store money directly end...");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

        // gc，触发finalize
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}