package org.moonzhou.proxy;

/**
 * @Description 普通biz类，无继承接口
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/25
 */
public class CommonBiz {

    public CommonBiz() {
        System.out.println("init common biz, in constructor method.");
    }

    public void execute() {
        System.out.println("doing common biz...");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public void executeOhters() {
        System.out.println("doing common other biz...");
    }
}
