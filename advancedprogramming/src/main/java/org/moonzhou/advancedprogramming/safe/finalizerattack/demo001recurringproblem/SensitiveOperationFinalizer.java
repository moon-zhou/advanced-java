package org.moonzhou.advancedprogramming.safe.finalizerattack.demo001recurringproblem;

/**
 * 通过重写finalize方法来绕过无法实例化对象，进而无法调用实例化方法问题
 */
public class SensitiveOperationFinalizer extends  SensitiveOperation{

    public SensitiveOperationFinalizer(){
    }

    @Override
    protected void finalize() {
        System.out.println("We can still do store Money action!");
        this.storeMoney();
        System.exit(0);
    }
}
