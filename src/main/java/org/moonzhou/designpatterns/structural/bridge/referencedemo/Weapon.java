package org.moonzhou.designpatterns.structural.bridge.referencedemo;

/**
 * 主功能抽象接口：武器
 *     抽象使用步骤
 *
 *     reference:https://github.com/iluwatar/java-design-patterns/tree/master/bridge
 * @author moon-zhou
 * @date 2020-01-21 11:22
 */
public interface Weapon {
    /**
     * 手持
     */
    void wield();

    /**
     * 挥舞
     */
    void swing();

    /**
     * 收回
     */
    void unwield();

    /**
     * 表明接口实现类里，必须有Enchantment属性
     *     同理，无该方法也行，提取该属性，将该接口改为抽象类即可
     *     为了面向接口编程，进行抽象类去除化
     * @return
     */
    Enchantment getEnchantment();
}