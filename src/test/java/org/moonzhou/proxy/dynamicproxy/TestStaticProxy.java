package org.moonzhou.proxy.dynamicproxy;

import org.junit.Test;
import org.moonzhou.proxy.dynamicproxy.impl.BizImpl;
import org.moonzhou.proxy.dynamicproxy.proxyImpl.BizProxy;

/**
 * @Description 测试静态代理
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class TestStaticProxy {

    @Test
    public void testRun() {
        IBiz biz = new BizImpl();

        BizProxy bizProxy = new BizProxy(biz);

        bizProxy.execute();
    }
}
