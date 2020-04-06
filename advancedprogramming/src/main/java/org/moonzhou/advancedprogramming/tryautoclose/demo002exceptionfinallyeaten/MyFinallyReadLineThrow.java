package org.moonzhou.advancedprogramming.tryautoclose.demo002exceptionfinallyeaten;

/**
 * 自定义方法，在try-catch里抛出，来验证finally里的异常可以把try里的覆盖掉
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/5 20:56
 * @since 1.0
 */
public class MyFinallyReadLineThrow {
    public void close() throws Exception {
        throw new Exception("close");
    }

    public void readLine() throws Exception {
        throw new Exception("readLine");
    }
}
