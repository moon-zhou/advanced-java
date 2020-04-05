package org.moonzhou.designpatterns.behavioralmode.templatemethod.simpledemo;

/**
 * @author moon-zhou
 * @date 2019-12-29
 */
public class ConcreteTemplate extends AbstractTemplate{
    /**
     * 基本方法的实现
     */
    @Override
    public void abstractMethod() {
        //业务相关的代码
    }

    /**
     * 重写父类的方法
     *     1. 如果没有具体的实现，也可以继续使用父类空方法
     *     2. 如果父类有通用的执行逻辑，子类也可以直接调用父类的实现
     */
    @Override
    public void hookMethod() {
        //业务相关的代码
    }
}