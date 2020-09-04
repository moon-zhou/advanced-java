package org.moonzhou.advancedprogramming.safe.finalizerattack.demo005jdkadvancedfeature2fix;

/**
 * 在JDK6或者更高版本中，如果对象的构造函数在java.lang.Object构造函数退出之前引发异常，则JVM将不会执行该对象的finalize方法。
 *
 * 因为Java确保java.lang.Object构造函数在任何构造函数的第一条语句之上或之前执行。
 * 如果构造函数中的第一个语句是对超类的构造函数或同一个类中的另一个构造函数的调用，则java.lang.Object构造函数将在该调用中的某个位置执行。
 * 否则，Java将在该构造函数的代码中的任何一个执行之前执行超类的默认构造函数，并且将通过隐式调用执行java.lang.Object构造函数。
 * 也就是说如果异常发生在构造函数中的第一条this或者super中的时候，JVM将不会调用对象的finalize方法
 *
 * 链接：https://juejin.im/post/6867325323000676359
 */
public class SensitiveOperationThis {

    public SensitiveOperationThis(){
        this(doSecurityCheck());
    }

    private SensitiveOperationThis(boolean secure) {
    }

    //Security check return false
    private static boolean doSecurityCheck(){
         throw new SecurityException("Security check failed!");
    }

    public void storeMoney(){
        System.out.println("Store 1000000 RMB!");
    }
}
