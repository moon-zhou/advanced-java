package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * @Description 懒汉模式 3.0
 *     1. 一次判空
 *     2. 程非安全(获取实例方法加同步关键字synchronized)
 *     3. 锁粒度过大
 *     4. 反射安全
 *
 * 参考：https://github.com/iluwatar/java-design-patterns/blob/master/singleton/src/main/java/com/iluwatar/singleton/ThreadSafeDoubleCheckLocking.java
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/11/13
 */
public class LazyLoadModeThreadReflectionSafeSingleton implements Singleton {

    private static LazyLoadModeThreadReflectionSafeSingleton INSTANCE;

    private static boolean flag = true;

    private LazyLoadModeThreadReflectionSafeSingleton() {
        // 防止通过反射进行实例化
        if (flag) {
            flag = false;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static synchronized LazyLoadModeThreadReflectionSafeSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyLoadModeThreadReflectionSafeSingleton();
        }

        return INSTANCE;
    }
}
