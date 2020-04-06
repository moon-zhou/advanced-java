package org.moonzhou.advancedprogramming.tryautoclose.demo003autoclose;

/**
 * 实现自定义的自动关闭示例
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:08
 * @since 1.0
 */
public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("关闭自定义资源");
    }
}
