package org.moonzhou.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * @Description 动态代理，使用JDK方式
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class BizDynamicProxyV1 extends DynamicProxy {

    /**
     * 代理类里包含了具体的业务逻辑，因为避免静态代理类的爆炸，动态代理只有一个，需要将代理时需要完成的业务进行解耦
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("dynamic proxy: before biz...");

        result = method.invoke(super.getTarget(), args);

        System.out.println("dynamic proxy: after biz...");

        return result;
    }
}
