package org.moonzhou.designpatterns.creationmode.singleton;

/**
 * 饿汉模式
 *     1. 类加载时，即生成实例化对象
 *     2. 线程安全
 *     3. 容易产生垃圾（一开始就有实例化对象，不一定会使用）
 *
 * @author moon zhou
 */
public class HungryModeSingleton implements Singleton {
 
   private static HungryModeSingleton INSTANCE = new HungryModeSingleton();

   private HungryModeSingleton(){}
 
   public static HungryModeSingleton getInstance(){
      return INSTANCE;
   }
 
}