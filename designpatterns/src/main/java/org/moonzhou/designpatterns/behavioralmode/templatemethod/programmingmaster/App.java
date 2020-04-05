package org.moonzhou.designpatterns.behavioralmode.templatemethod.programmingmaster;

/**
 * @Description 测试如何成为一名编程大师
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/29
 */
public class App {
    public static void main(String[] args) {
        AbstractProgrammingMaster javaMaster = new JavaerProgrammingMaster();
        javaMaster.beMaster();

        AbstractProgrammingMaster frontEndMaster = new FrontEndProgrammingMaster();
        frontEndMaster.beMaster();
    }
}
