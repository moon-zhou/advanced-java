package org.moonzhou.designpatterns.structural.bridge.referencedemo;

/**
 * 武器使用测试类<br>
 *
 * @author moon-zhou
 * @date: 2020/1/21 11:59
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class App {
    public static void main(String[] args) {
        Weapon enchantedSword = new Sword(new SoulEatingEnchantment());
        enchantedSword.wield();
        enchantedSword.swing();
        enchantedSword.unwield();
// The sword is wielded.
// The item spreads bloodlust.
// The sword is swinged.
// The item eats the soul of enemies.
// The sword is unwielded.
// Bloodlust slowly disappears.

//        Enchantment hammer = new Hammer(new FlyingEnchantment());
        Weapon hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
// The hammer is wielded.
// The item begins to glow faintly.
// The hammer is swinged.
// The item flies and strikes the enemies finally returning to owner's hand.
// The hammer is unwielded.
// The item's glow fades.
    }
}
