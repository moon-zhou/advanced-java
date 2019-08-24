package org.moonzhou.proxy.staticproxy.impl;

import org.moonzhou.proxy.staticproxy.IBiz;

/**
 * @Description 业务逻辑实现类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class BizImpl implements IBiz {
    @Override
    public void execute() {
        System.out.println("doing biz...");
    }
}
