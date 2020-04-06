package org.moonzhou.advancedprogramming.tryautoclose.demo004autocloseadvanced;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:21
 * @since 1.0
 */
public class TryWithResourcesOut {
    public static void main(String[] args) {
        try (MyResourceOut myResourceOut = new MyResourceOut()) {
            myResourceOut.out();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
