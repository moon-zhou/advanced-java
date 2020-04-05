package org.moonzhou.proxy.dynamicproxy.proxybiz.impl;

import org.moonzhou.proxy.dynamicproxy.proxybiz.ILog;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/24
 */
public class LogImpl implements ILog {
    @Override
    public void out(Object o) {
        System.out.println(o.toString());
    }

    @Override
    public void before() {
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("start dynamic proxy V2: before biz..., start time is " + currentTime);
    }

    @Override
    public void before(Method method) {
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println(method.getName() + " start dynamic proxy V2: before biz..., start time is " + currentTime);
    }

    @Override
    public void after() {
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("start dynamic proxy V2: after biz..., start time is " + currentTime);
    }

    @Override
    public void after(Method method) {
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println(method.getName() + " start dynamic proxy V2: after biz..., start time is " + currentTime);
    }
}
