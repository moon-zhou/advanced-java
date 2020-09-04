package org.moonzhou.advancedprogramming.safe.finalizerattack.demo003finalmethodsuperclass2fix;

/**
 * 父类为了避免被子类通过finalize绕过，进行方法调用，直接将finalize方法设置为final，
 * 子类虽然可以继承，但是无法重写finalize方法，也就无法绕过
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
    
    @Override
    final protected void finalize() {
    }
}
