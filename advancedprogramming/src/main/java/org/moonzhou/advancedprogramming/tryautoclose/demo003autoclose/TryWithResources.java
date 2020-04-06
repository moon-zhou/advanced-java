package org.moonzhou.advancedprogramming.tryautoclose.demo003autoclose;

/**
 * 测试自动关闭
 *
 * 原因：初始化实现了AutoCloseable接口的类时，再编译的过程中，在其外部使用了try-catch，内部执行语句，又嵌套了一层try-catch
 * 详细见此类对应的编译class
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:09
 * @since 1.0
 */
public class TryWithResources {
    public static void main(String[] args) {
        try (MyResource myResource = new MyResource();) {
//            System.out.println("测试无finally显示关闭，自动隐式关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
