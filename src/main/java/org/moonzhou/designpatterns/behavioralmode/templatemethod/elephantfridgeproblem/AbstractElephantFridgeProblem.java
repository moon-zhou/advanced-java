package org.moonzhou.designpatterns.behavioralmode.templatemethod.elephantfridgeproblem;

/**
 * @Description 把大象放冰箱问题
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public abstract class AbstractElephantFridgeProblem {

    /**
     * 把大象放冰箱步骤
     *     1. 把冰箱门打开
     *     2. 把大象放进去
     *     3. 把冰箱门关上
     *     4. 噢耶
     */
    public void putElephantInFridge() {

        openFridgeDoor();

        putElephantIn();

        closeFridgeDoor();

        endOhYeah();
    }

    /**
     * 抽象打开冰箱门方法：可能打开海尔的冰箱门，可能打开美的的冰箱门，也可能打开西门子的冰箱门
     */
    protected abstract void openFridgeDoor();

    /**
     * 关闭冰箱门方法，与打开冰箱门一致
     */
    protected abstract void closeFridgeDoor();

    /**
     * 把大象放进去
     * 默认放的就是这只大象
     * 子类可以复写，放进去不同的大象，也可以就放这只大象
     */
    public void putElephantIn() {
        // 该大象来自喜羊羊与灰太狼
        System.out.println("把包包大人这只大象装进去");
    }

    private void endOhYeah() {
        System.out.println("噢耶！！！");
    }
}
