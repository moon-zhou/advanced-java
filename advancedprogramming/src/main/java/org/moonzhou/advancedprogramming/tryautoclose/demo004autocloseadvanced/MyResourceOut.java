package org.moonzhou.advancedprogramming.tryautoclose.demo004autocloseadvanced;

/**
 * AutoCloseable实现扩展，用于比对字节码
 * https://juejin.im/post/5e87cb9be51d4546cf777342
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:17
 * @since 1.0
 */
public class MyResourceOut implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("关闭自定义资源");
    }

    public void out() throws Exception {
        System.out.println("a handsome boy...");
    }
}
