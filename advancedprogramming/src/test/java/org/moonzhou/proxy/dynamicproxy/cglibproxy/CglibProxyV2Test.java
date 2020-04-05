package org.moonzhou.proxy.dynamicproxy.cglibproxy;

import org.junit.Test;
import org.moonzhou.proxy.CommonBiz;
import org.moonzhou.proxy.dynamicproxy.cglibproxy.v2.CglibProxyV2;
import org.moonzhou.proxy.dynamicproxy.proxybiz.ILog;
import org.moonzhou.proxy.dynamicproxy.proxybiz.impl.LogImpl;

/**
 * 测试cglib实现的动态代理
 */
public class CglibProxyV2Test {

    @Test
    public void testRun() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        /*Properties sourceCodePath = new Properties();
        sourceCodePath.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\TestCode\\cglib\\v2");
        System.setProperties(sourceCodePath);*/

        CommonBiz commonBiz = new CommonBiz();
        ILog log = new LogImpl();

        CglibProxyV2 cglibProxyV2 = new CglibProxyV2(commonBiz, log);
        CommonBiz bizProxy = (CommonBiz) cglibProxyV2.newProxy();
        bizProxy.execute();
    }
}