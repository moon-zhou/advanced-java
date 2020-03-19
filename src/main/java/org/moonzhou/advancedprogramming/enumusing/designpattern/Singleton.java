package org.moonzhou.advancedprogramming.enumusing.designpattern;

/**
 * @Description 单例模式
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/19
 */
public class Singleton {
    /**
     * 构造函数私有化，避免外部创建实例
     */
    private Singleton() {

    }

    /**
     * 定义一个内部枚举
     */
    public enum SingletonEnum {

        /**
         * 唯一一个枚举对象，我们称它为“种子选手”！
         */
        SEED;

        private Singleton singleton;

        SingletonEnum() {
            // 真正的对象创建隐蔽在此！
            singleton = new Singleton();
        }

        public Singleton getInstnce() {
            return singleton;
        }
    }

    /**
     * 故意外露的对象获取方法，也是外面获取实例的唯一入口
     *
     * @return
     */
    public static Singleton getInstance() {
        // 通过枚举的种子选手来完成
        return SingletonEnum.SEED.getInstnce();
    }
}
