package org.moonzhou.proxy.dynamicproxy.cglibproxy.v2;

import net.sf.cglib.proxy.Enhancer;
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
public class CglibProxyV2 implements MethodInterceptor {

    /**
     * 要代理的原始对象(业务处理类)
     */
    private Object target;

    /**
     * 代理里需要处理的业务（如日志打印等）
     */
    private Object proxyBiz;

    public CglibProxyV2(Object target, Object proxyBiz) {
        this.target = target;
        this.proxyBiz = proxyBiz;
    }

    /**
     * 创建代理类
     *
     * @param target 实际的业务类
     * @return
     */
    public Object newProxy() {
        // 通过cglib动态代理获取代理对象过程(类比JDK动态代理里的Proxy，但Enhancer更强大，既可以代理接口，也可以代理普通类，但不能拦截final方法)
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类，即业务类(需要被代理的类)
        enhancer.setSuperclass(this.target.getClass());

        // 设置enhancer的回调对象，当前类的实例对象
        enhancer.setCallback(this);

        enhancer.setClassLoader(this.target.getClass().getClassLoader());

        return enhancer.create();
    }

    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * args：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before(method);

        Object result;
        try {
            result = methodProxy.invokeSuper(sub, args);
        } finally {
            after(method);
        }

        return result;
    }

    /**
     * 目标方法执行前调用
     * @param method
     * @throws Throwable
     */
    private void before(Method method) throws Throwable {
        // 反射得到操作者的实例
        Class proxyBizClass = this.proxyBiz.getClass();

        // 反射得到操作者的before方法（目标方法执行之前执行的方法）
        Method before = proxyBizClass.getDeclaredMethod("before", new Class[]{Method.class});

        // 反射执行before方法
        before.invoke(this.proxyBiz, new Object[]{method});
    }

    /**
     * 目标方法处理完调用，异常也会执行
     * @param method
     * @throws Throwable
     */
    private void after(Method method) throws Throwable {
        // 反射得到操作者的实例
        Class proxyBizClass = this.proxyBiz.getClass();

        // 反射得到操作者的after方法（目标方法执行后再执行的方法）
        Method after = proxyBizClass.getDeclaredMethod("after", new Class[]{Method.class});

        // 反射执行after方法
        after.invoke(this.proxyBiz, new Object[]{method});
    }
}
