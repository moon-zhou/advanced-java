package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * @Description 枚举单例
 *     1. 简洁
 *     2. 自动支持序列化机制
 *     3. 线程安全
 *     4. 反射安全
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/11/13
 */
public enum SingletonEnum {

    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
