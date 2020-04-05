package org.moonzhou.proxy.dynamicproxy.cglibproxy.v1;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description cglib实现动态代理
 * 与jdk动态代理的第一个版本一样，代理时处理的业务逻辑侵入了具体代理里，需要进行解耦
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/25
 */
public class CglibProxyV1 implements MethodInterceptor {

    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * args：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 可优化，见V2
        System.out.println("cglib proxy before method...");

        Object result = methodProxy.invokeSuper(sub, args);

        // 可优化，见V2
        System.out.println("cglib proxy after method...");

        return result;
    }
}
