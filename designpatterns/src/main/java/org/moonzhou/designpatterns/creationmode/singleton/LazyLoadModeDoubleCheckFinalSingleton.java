package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * 单例模式 ：懒汉模式 5.0 双重检查锁
 * 1. 线程安全
 * 2. 反射安全
 * 3. 本地变量提高执行效率（JDK 10以上实施，代码已注释）
 * 4. 指令重排序的情况下，线程也安全
 * <p>
 * 参考：https://github.com/iluwatar/java-design-patterns/blob/master/singleton/src/main/java/com/iluwatar/singleton/ThreadSafeDoubleCheckLocking.java
 *
 * @author moon zhou
 */
public class LazyLoadModeDoubleCheckFinalSingleton implements Singleton {

    /**
     * 第二层锁，volatile关键字禁止指令重排
     */
    private static volatile LazyLoadModeDoubleCheckFinalSingleton INSTANCE;

    private static boolean flag = true;

    private LazyLoadModeDoubleCheckFinalSingleton() {

        /*
         * 反射demo：
         * Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
         * constructor.setAccessible(true);
         * Singleton s2 = constructor.newInstance();
         */

        // 防止通过反射进行实例化
        if (flag) {
            flag = false;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public LazyLoadModeDoubleCheckFinalSingleton getInstance() {

        // 第一层检查，检查是否有引用指向对象，高并发情况下会有多个线程同时进入
        if (null == INSTANCE) {

            // 锁，同步关键字，保证只有一个线程进入
            synchronized (LazyLoadModeDoubleCheckFinalSingleton.class) {

                /*
                 * 双重检查，防止多个线程同时进入第一层检查(因单例模式只允许存在一个对象，故在创建对象之前无引用指向对象，
                 * 所以当某一线程获得锁创建一个Singleton对象时,即已有引用指向对象，singleton不为空，从而保证只会创建一个对象
                 * 如果没有第二层检查，那么第一个线程创建完对象释放锁后，后面进入对象也会创建对象，会产生多个对象
                 */
                if (null == INSTANCE) {
                    /*
                     * error
                     * 语句为非原子性，实际上会执行以下内容：
                     *     1. new出来的对象在堆上开辟空间
                     *     2. 执行构造器方法的逻辑代码片段，比如属性初始化
                     *     3. 完成instance引用的赋值操作，将其指向刚刚开辟的内存地址
                     *
                     * 指令重排序存在的问题是：1-3-2
                     *     线程1 执行1-3-2，执行到1-3时，2还没有进行初始化
                     *     线程2 第一次检查==null时，判断不为空，直接返回使用，此时，对象还未完全初始化完成，使用很能出现异常
                     *
                     * 添加volatile关键字，保证指令不进行重排序
                     */
                    INSTANCE = new LazyLoadModeDoubleCheckFinalSingleton();
                }
            }
        }
        return INSTANCE;

        // local variable increases performance by 25 percent
        // Joshua Bloch "Effective Java, Second Edition", p. 283-284
        // JDK 10以上测试
        /*var result = INSTANCE;

        if (result == null) {
            synchronized (LazyLoadModeDoubleSynCheckRefactionSafeSingleton.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new LazyLoadModeDoubleSynCheckRefactionSafeSingleton();
                }
            }
        }

        return result;*/
    }
}  
