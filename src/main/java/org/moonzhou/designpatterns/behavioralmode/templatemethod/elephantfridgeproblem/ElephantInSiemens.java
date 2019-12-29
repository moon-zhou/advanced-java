package org.moonzhou.designpatterns.behavioralmode.templatemethod.elephantfridgeproblem;

/**
 * @Description 把蜡笔小新的大象放进西门子双开门冰箱里
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public class ElephantInSiemens extends AbstractElephantFridgeProblem {

    @Override
    protected void openFridgeDoor() {
        System.out.println("打开西门子双开门冰箱门");
    }

    @Override
    public void putElephantIn() {
        System.out.println("把蜡笔小新的大象放进去");
    }

    @Override
    protected void closeFridgeDoor() {
        System.out.println("关上西门子双开门冰箱门");
    }
}
