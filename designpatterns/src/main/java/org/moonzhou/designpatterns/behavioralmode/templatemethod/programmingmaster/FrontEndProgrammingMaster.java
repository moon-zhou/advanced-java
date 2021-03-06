package org.moonzhou.designpatterns.behavioralmode.templatemethod.programmingmaster;

/**
 * @Description 如何成为一名前端大师
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public class FrontEndProgrammingMaster extends AbstractProgrammingMaster {
    @Override
    protected void learnBasicTechniques() {
        System.out.println();
        System.out.println("如何成为一名前端大师，分以下几步：");

        System.out.println("第一阶段：学习基础技术。该阶段需要阅读的书籍：");
        System.out.println("《数据结构》《软件工程》《CSS》《JS》《JQuery》《VUE》《RN》");
    }
}
