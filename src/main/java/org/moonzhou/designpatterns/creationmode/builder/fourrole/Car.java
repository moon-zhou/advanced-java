package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 汽车的类
 *
 * 含轮胎和引擎，因此使用聚合的关系
 *
 * @author moon-zhou
 * @date 2020-1-5
 */
public class Car {

    /**
     * 轮胎
     */
    private Tyre tyre;

    /**
     * 引擎
     */
    private Engine engine;

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}