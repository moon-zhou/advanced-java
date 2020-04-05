package org.moonzhou.designpatterns.behavioralmode.templatemethod.programmingmaster;

/**
 * @Description 编程大师之路
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public abstract class AbstractProgrammingMaster {

    /**
     * 模板方法：如何成为编程大师
     *     1. 学习基础技术
     *     2. 锻炼心智
     *     3. 关注身体健康
     *     4. 继续死磕
     *     5. Just Live
     */
    public final void beMaster() {
        learnBasicTechniques();

        exerciseMind();

        focusOnHealth();

        keepDoing();

        justAlive();
    }

    /**
     * 学习基础技术，每一个方向开发学习的技术均有差异，如前端，后端，大数据，安全...
     */
    protected abstract void learnBasicTechniques();

    /**
     * 锻炼心智
     */
    private void exerciseMind() {
        System.out.println("第二阶段：锻炼心智。该阶段需要阅读的书籍：");
        System.out.println("《莫生气》《佛经》《老子》《思想政治》《论持久战》…… ");
    }

    /**
     * 关注身体健康
     */
    private void focusOnHealth() {
        System.out.println("第三阶段：关注身体健康。该阶段需要阅读的书籍：");
        System.out.println("《颈椎病康复指南》《腰间盘突出日常护理》《心脏病的预防与治疗》《高血压降压宝典》…… ");
    }

    /**
     * 继续死磕
     */
    private void keepDoing() {
        System.out.println("第四阶段：继续死磕。该阶段需要阅读的书籍：");
        System.out.println("《迷恋》《谢谢你折磨我》《自私与贪婪》《走向奴役之路》…… ");
    }

    /**
     * 终极极端：只是活着
     */
    private void justAlive() {
        System.out.println("终极阶段：活着。该阶段需要阅读的书籍：");
        System.out.println("《活着》");
    }
}
