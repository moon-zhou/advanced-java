package org.moonzhou.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description V1进阶，将业务逻辑从动态代理类里解耦
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class BizDynamicProxyV2 extends DynamicProxy {

    /**
     * 调用对象
     */
    private Object proxyBiz;

    public Object newProxy(Object target, Object proxyBiz) {
        this.setTarget(target);
        this.proxyBiz = proxyBiz;

        return Proxy.newProxyInstance(this.getTarget().getClass().getClassLoader(),
                this.getTarget().getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxyT, Method method, Object[] args) throws Throwable {
        Object result = null;

        // 反射得到操作者的实例
        Class proxyBizClass = this.proxyBiz.getClass();

        // 反射得到操作者的before方法（目标方法执行之前执行的方法）
        Method before = proxyBizClass.getDeclaredMethod("before", new Class[]{Method.class});
//        Method before = proxyBizClass.getDeclaredMethod("before");

        // 反射执行before方法
        before.invoke(this.proxyBiz, new Object[]{method});
//        before.invoke(this.proxy);

        // 执行目标方法
        method.invoke(this.getTarget(), args);

        // 反射得到操作者的after方法（目标方法执行后再执行的方法）
        Method after = proxyBizClass.getDeclaredMethod("after", new Class[]{Method.class});
//        Method after = proxyBizClass.getDeclaredMethod("after");

        // 反射执行after方法
        after.invoke(this.proxyBiz, new Object[]{method});
//        after.invoke(this.proxy);

        return result;
    }
}
