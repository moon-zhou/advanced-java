package org.moonzhou.designpatterns.structural.bridge.referencedemo;

/**
 * 具备远程攻击魔法实现类
 *
 * @author moon-zhou
 * @date 2020-01-21
 */
public class FlyingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        System.out.println("The item begins to glow faintly.");
    }

    @Override
    public void apply() {
        System.out.println("The item flies and strikes the enemies finally returning to owner's hand.");
    }

    @Override
    public void onDeactivate() {
        System.out.println("The item's glow fades.");
    }
}