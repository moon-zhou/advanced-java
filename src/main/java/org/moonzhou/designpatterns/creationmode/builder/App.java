package org.moonzhou.designpatterns.creationmode.builder;

import org.moonzhou.designpatterns.creationmode.builder.fourrole.BuilderCar;
import org.moonzhou.designpatterns.creationmode.builder.fourrole.Car;
import org.moonzhou.designpatterns.creationmode.builder.fourrole.Director;
import org.moonzhou.designpatterns.creationmode.builder.fourrole.DirectorCar;
import org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting.HouseArea;
import org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting.HouseFloor;
import org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting.HouseLayout;
import org.moonzhou.designpatterns.creationmode.builder.simplifiedscripting.MyHouse;

/**
 * @Description 测试构建者类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
public class App {

    public static void main(String[] args) {
        testFourRole();

        testSimplifiedScripting();
    }

    private static void testFourRole() {
        // 创建指挥者的对象
        Director director = new DirectorCar(new BuilderCar());

        // 获取组装完成的
        Car car = director.CreateCar();

        System.out.println(car.getEngine().getName());
        System.out.println(car.getTyre().getName());
    }

    private static void testSimplifiedScripting() {
        MyHouse myHouse = new MyHouse.Builder("first house", HouseArea.JIANGNING)
                .withHouseLayout(HouseLayout.VILLA)
                .withHouseFloor(HouseFloor.LOW_RISE)
                .build();

        System.out.println("My house is: " + myHouse);
    }
}
