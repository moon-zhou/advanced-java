package org.moonzhou.proxy.dynamicproxy.jdkproxy;

import org.junit.Test;
import org.moonzhou.proxy.IBiz;
import org.moonzhou.proxy.dynamicproxy.proxybiz.ILog;
import org.moonzhou.proxy.dynamicproxy.proxybiz.impl.LogImpl;
import org.moonzhou.proxy.impl.BizImpl;

/**
 * 动态代理测试类
 */
public class BizDynamicProxyTest {

    @Test
    public void testV1Run() {
        IBiz biz = new BizImpl();

        DynamicProxy bizDynamicProxyV1 = new BizDynamicProxyV1();

        IBiz bizProxy = (IBiz) bizDynamicProxyV1.newProxy(biz);
        bizProxy.execute();
    }

    @Test
    public void testV2Run() {
        // 目标执行的业务实现
        IBiz biz = new BizImpl();

        // 代理需要的业务逻辑
        ILog log = new LogImpl();

        // 创建代理
        BizDynamicProxyV2 bizDynamicProxyV2 = new BizDynamicProxyV2();
        IBiz bizProxy = (IBiz) bizDynamicProxyV2.newProxy(biz, log);
        bizProxy.execute();
    }
}