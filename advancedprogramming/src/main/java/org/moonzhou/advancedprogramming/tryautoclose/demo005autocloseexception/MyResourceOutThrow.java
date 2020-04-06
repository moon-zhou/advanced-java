package org.moonzhou.advancedprogramming.tryautoclose.demo005autocloseexception;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 21:25
 * @since 1.0
 */
public class MyResourceOutThrow implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("close()");
    }

    public void out() throws Exception{
        throw new Exception("out()");
    }
}
