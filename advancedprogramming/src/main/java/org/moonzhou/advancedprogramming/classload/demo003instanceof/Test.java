package org.moonzhou.advancedprogramming.classload.demo003instanceof;

import lombok.extern.slf4j.Slf4j;
import sun.security.provider.Sun;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/4/25 16:27
 */
public class Test {
    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();

        System.out.println(f.getClass());
        System.out.println(s.getClass());

        System.out.println();
        System.out.println(f instanceof Father);
        System.out.println(s instanceof Father);
        System.out.println(s instanceof Son);

        System.out.println();
        System.out.println(f.getClass().equals(Father.class));
        System.out.println(s.getClass().equals(Father.class));
        System.out.println(s.getClass().equals(Son.class));
    }

    static class Father{}
    static class Son extends Father{}
}
