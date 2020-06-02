package org.moonzhou.designpatterns.creationmode.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS保证线程安全产生单例对象实例
 * <p>
 * 参考：https://juejin.im/post/5ed357fa518825431b081a03
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/6/1 20:26
 * @since 1.0
 */
public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<CASSingleton>();

    private static CASSingleton casSingleton;

    private CASSingleton() {

    }

    public static final CASSingleton getInstance() {
        // CAS忙等
        for (; ; ) {

            CASSingleton instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }

            INSTANCE.compareAndSet(null, new CASSingleton());

            return INSTANCE.get();
        }
    }

}
