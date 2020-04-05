package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 抽象建造者(实际上是一个接口，其中定义了建造轮胎和引擎的方法)
 *
 * @author moon-zhou
 * @date 2020-1-5
 */
public interface Builder {
    /**
     * 构造引擎的方法
     */
    Engine buildEngine();

    /**
     * 构造轮胎的方法
     */
    Tyre buildTyre();
}