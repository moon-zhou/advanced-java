package org.moonzhou.designpatterns.structural.bridge.referencedemo;

/**
 * 灵魂类伤害武器
 *
 * @author moon-zhou
 * @date 2020-01-21
 */
public class SoulEatingEnchantment implements Enchantment {

    @Override
    public void onActivate() {
        System.out.println("The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        System.out.println("The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        System.out.println("Bloodlust slowly disappears.");
    }
}