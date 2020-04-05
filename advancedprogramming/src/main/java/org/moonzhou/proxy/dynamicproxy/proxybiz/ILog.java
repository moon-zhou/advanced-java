package org.moonzhou.proxy.dynamicproxy.proxybiz;

import java.lang.reflect.Method;

/**
 * @Description 代理内部业务接口
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public interface ILog {
    /**
     * 通用输出接口
     */
    void out(Object o);

    /**
     * 方法开始时输出
     */
    void before();
    void before(Method method);

    /**
     * 方法结束时输出
     */
    void after();
    void after(Method method);
}
