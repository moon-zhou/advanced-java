package org.moonzhou.designpatterns.creationmode.builder.fourrole;

/**
 * 指挥者的实现类
 *
 * @author moon-zhou
 * @date 2020-1-5
 */
public class DirectorCar implements Director {

    /**
     * 建造者的对象
     */
    private Builder builder;

    /**
     * 构造方法，主要用来初始化建造者对象
     *
     * @param builder Builder的对象
     */
    public DirectorCar(Builder builder) {
        this.builder = builder;
    }

    @Override
    public Car CreateCar() {
        Engine engine = builder.buildEngine();
        Tyre tyre = builder.buildTyre();

        Car car = new Car();
        car.setEngine(engine);
        car.setTyre(tyre);

        // 返回构造好的汽车
        return car;
    }
}