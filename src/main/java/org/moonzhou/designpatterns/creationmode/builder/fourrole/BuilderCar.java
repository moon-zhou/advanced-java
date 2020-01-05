package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 具体的建造者，主要是构造汽车的部件
 *
 * @author moon-zhou
 * @date 2020-1-5
 */
public class BuilderCar implements Builder {

    @Override
    public Engine buildEngine() {
        System.out.println("构造汽车发动机");

        return new Engine("Super发动机");
    }

    @Override
    public Tyre buildTyre() {
        System.out.println("构造汽车轮胎");

        return new Tyre("Super轮胎");
    }
}
