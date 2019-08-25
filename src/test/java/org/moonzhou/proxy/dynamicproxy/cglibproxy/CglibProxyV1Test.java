package org.moonzhou.proxy.dynamicproxy.cglibproxy;

import java.util.Properties;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.moonzhou.proxy.CommonBiz;
import org.moonzhou.proxy.dynamicproxy.cglibproxy.v1.CglibProxyV1;
import org.moonzhou.proxy.dynamicproxy.cglibproxy.v2.CglibProxyV2;
import org.moonzhou.proxy.dynamicproxy.proxybiz.ILog;
import org.moonzhou.proxy.dynamicproxy.proxybiz.impl.LogImpl;

/**
 * 测试cglib实现的动态代理
 */
public class CglibProxyV1Test {

    @Test
    public void testRun() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        Properties sourceCodePath = new Properties();
        sourceCodePath.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\TestCode\\cglib\\v1");
        System.setProperties(sourceCodePath);

        // 通过cglib动态代理获取代理对象过程(类比JDK动态代理里的Proxy，但Enhancer更强大，既可以代理接口，也可以代理普通类，但不能拦截final方法)
        Enhancer enhancer = new Enhancer();

        // 设置enhancer对象的父类，即业务类(需要被代理的类)
        enhancer.setSuperclass(CommonBiz.class);

        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibProxyV1());

        // 创建代理对象
        CommonBiz commonBizProxy = (CommonBiz) enhancer.create();

        // 通过代理对象调用目标方法
        commonBizProxy.execute();
    }
}