package org.moonzhou.designpatterns.behavioralmode.templatemethod.elephantfridgeproblem;

/**
 * @Description 把包包大人放进海尔冰箱
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public class ElephantInHaier extends AbstractElephantFridgeProblem {
    @Override
    protected void openFridgeDoor() {
        System.out.println("打开海尔无霜冰箱门");
    }

    @Override
    protected void closeFridgeDoor() {
        System.out.println("关上海尔无霜冰箱门");
    }
}
