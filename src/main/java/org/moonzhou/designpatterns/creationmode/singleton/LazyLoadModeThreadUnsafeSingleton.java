package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * @Description 懒汉模式 1.0
 *     1. 一次判空
 *     2. 线程非安全
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/11/13
 */
public class LazyLoadModeThreadUnsafeSingleton implements Singleton {

    private static LazyLoadModeThreadUnsafeSingleton INSTANCE;

    private LazyLoadModeThreadUnsafeSingleton() {
    }

    public static LazyLoadModeThreadUnsafeSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyLoadModeThreadUnsafeSingleton();
        }

        return INSTANCE;
    }
}
