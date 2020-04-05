package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * 单例模式 ：懒汉模式 4.0 双重检查锁
 *     1. 线程安全
 *     2. 反射非安全
 * @author moon zhou
 */
public class LazyLoadModeDoubleSynCheckSingleton implements Singleton {
    private static LazyLoadModeDoubleSynCheckSingleton INSTANCE;

    private LazyLoadModeDoubleSynCheckSingleton() {
        
    }

    public LazyLoadModeDoubleSynCheckSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (LazyLoadModeDoubleSynCheckSingleton.class) {
                if (null == INSTANCE) {
                    // error
                    INSTANCE = new LazyLoadModeDoubleSynCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}  
