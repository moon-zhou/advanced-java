package org.moonzhou.designpatterns.behavioralmode.templatemethod.elephantfridgeproblem;

/**
 * @Description 验证把大象放冰箱需要几步
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public class App {
    public static void main(String[] args) {
        // 把默认的包包大人放进海尔冰箱
        AbstractElephantFridgeProblem elephantInHaier = new ElephantInHaier();
        elephantInHaier.putElephantInFridge();

        // 把蜡笔小新的大象放进西门子冰箱
        AbstractElephantFridgeProblem elephantInSiemens = new ElephantInSiemens();
        elephantInSiemens.putElephantInFridge();
    }
}
