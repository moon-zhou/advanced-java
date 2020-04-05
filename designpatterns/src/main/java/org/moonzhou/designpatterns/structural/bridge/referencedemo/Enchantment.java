package org.moonzhou.designpatterns.structural.bridge.referencedemo;


/**
 * 详细职能抽象接口：XXX魔法伤害
 * @author moon-zhou
 * @date 2020-01-21 11:22
 */
public interface Enchantment {

    /**
     * 激活
     */
    void onActivate();

    /**
     * 使用
     */
    void apply();

    /**
     * 停用
     */
    void onDeactivate();
}