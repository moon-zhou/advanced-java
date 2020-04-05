package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * @Description 懒汉模式：静态内部类
 *     静态域使用延迟初始化
 *     LazyLoadModeInnerClassSingleton 类被装载了，instance 不一定被初始化。
 *     因为 SingletonContainer 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonContainer 类，从而实例化 instance。
 *
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/11/13
 */
public class LazyLoadModeInnerClassSingleton implements Singleton {

    private LazyLoadModeInnerClassSingleton(){}

    private static class SingletonContainer {
        private static LazyLoadModeInnerClassSingleton INSTANCE = new LazyLoadModeInnerClassSingleton();
    }

    public static LazyLoadModeInnerClassSingleton getInstance(){
        return SingletonContainer.INSTANCE;
    }
}
