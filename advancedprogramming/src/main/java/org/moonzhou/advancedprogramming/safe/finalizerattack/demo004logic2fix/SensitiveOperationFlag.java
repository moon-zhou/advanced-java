package org.moonzhou.advancedprogramming.safe.finalizerattack.demo004logic2fix;

/**
 * 方法执行时，加上前置条件判断，此处为必须实例化之后才能调用
 */
public class SensitiveOperationFlag {

    private volatile boolean flag= false;

    public SensitiveOperationFlag(){
        if(!doSecurityCheck()){
            throw new SecurityException("Security check failed!");
        }
        flag=true;
    }

    // Security check return false
    private boolean doSecurityCheck(){
        return false;
    }

    public void storeMoney(){
        if(!flag){
            System.out.println("Object is not initiated yet!");
            return;
        }
        System.out.println("Store 1000000 RMB!");
    }
}
