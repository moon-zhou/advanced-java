package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * @Description 懒汉模式 2.0
 *     1. 一次判空
 *     2. 程非安全(获取实例方法加同步关键字synchronized)
 *     3. 锁粒度过大
 *     4. 反射不安全
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/11/13
 */
public class LazyLoadModeThreadSafeSingleton implements Singleton {

    private static LazyLoadModeThreadSafeSingleton INSTANCE;

    private LazyLoadModeThreadSafeSingleton() {
    }

    public static synchronized LazyLoadModeThreadSafeSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyLoadModeThreadSafeSingleton();
        }

        return INSTANCE;
    }
}
