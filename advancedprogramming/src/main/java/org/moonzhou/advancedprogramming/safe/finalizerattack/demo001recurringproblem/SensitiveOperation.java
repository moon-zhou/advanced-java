package org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem;

/**
 * finalize安全示例
 */
public class SensitiveOperation {

    public SensitiveOperation(){
        if(!doSecurityCheck()){
            throw new SecurityException("Security check failed!");
        }
    }

    //Security check return false
    private boolean doSecurityCheck(){
        return false;
    }

    public void storeMoney(){
        System.out.println("Store 1000000 RMB!");
    }
}
