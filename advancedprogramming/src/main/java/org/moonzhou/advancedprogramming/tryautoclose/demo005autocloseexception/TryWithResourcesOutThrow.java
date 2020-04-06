package org.moonzhou.advancedprogramming.tryautoclose.demo005autocloseexception;

/**
 * 测试AutoCloseable如何避免最终异常被吃掉的情况
 *
 * 定义了一个全局的Throwable，本身执行的异常会被catch记录到这个Throwable变量里，
 * autoclose最终也是由finally实现，其中的关闭异常，通过addSuppressed()，把当前异常加进去
 * 详情见编译后的class文件
 *
 * https://juejin.im/post/5e87cb9be51d4546cf777342
 * 当一个异常被抛出的时候，可能有其他异常因为该异常而被抑制住，从而无法正常抛出。
 * 这时可以通过 addSuppressed() 方法把这些被抑制的方法记录下来。
 * 被抑制的异常会出现在抛出的异常的堆栈信息中，也可以通过 getSuppressed() 方法来获取这些异常。
 * 这样做的好处是不会丢失任何异常，方便我们开发人员进行调试。
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:26
 * @since 1.0
 */
public class TryWithResourcesOutThrow {

    public static void main(String[] args) {
        try (MyResourceOutThrow resource = new MyResourceOutThrow();) {
            resource.out();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
