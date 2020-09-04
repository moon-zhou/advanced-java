package org.moonzhou.advancedprogramming.safe.finalizerattack.demo002finalsuperclass2fix;

/**
 * 使用final class，那么类是不能够被继承的
 * 也就避免通过继承类里面，通过gc触发finalize来调用父类需要实例化才能调用的方法，也就是无法绕过进行调用
 */
public final class SensitiveOperationFinal {

    public SensitiveOperationFinal(){
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
