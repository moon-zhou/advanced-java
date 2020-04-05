package org.moonzhou.proxy.staticproxy;

import org.moonzhou.proxy.IBiz;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class BizStaticProxy implements IBiz {

    private IBiz biz;

    public BizStaticProxy(IBiz biz) {
        this.biz = biz;
    }

    @Override
    public void execute() {
        System.out.println("static proxy: before biz...");

        biz.execute();

        System.out.println("static proxy: after biz...");
    }
}
