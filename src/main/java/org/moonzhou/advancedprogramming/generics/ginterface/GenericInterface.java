package org.moonzhou.advancedprogramming.generics.ginterface;

/**
 * 泛型接口
 * @author moon-zhou
 * @date 2020-01-13
 * @param <T>
 */
public interface GenericInterface<T> {
    /**
     * 返回下一个值
     * @return
     */
    public T next();
}