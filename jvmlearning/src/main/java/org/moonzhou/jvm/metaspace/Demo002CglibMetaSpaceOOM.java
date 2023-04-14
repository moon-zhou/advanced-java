package org.moonzhou.jvm.metaspace;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m -XX:+PrintFlagsInitial
 *
 * Error occurred during initialization of VM
 * MaxMetaspaceSize is too small.
 *
 * @author moon zhou
 */
public class Demo002CglibMetaSpaceOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

}