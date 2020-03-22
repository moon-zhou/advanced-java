package org.moonzhou.agentdemo.simpledemo;

import java.lang.instrument.Instrumentation;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/3/22 20:25
 * @since 1.0
 */
public class SimpleAgentV3 {
    /**
     * jvm 参数形式启动，运行此方法
     *
     * manifest需要配置属性Premain-Class
     *
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("do premain, params: " + agentArgs);
    }

    /**
     * 动态 attach 方式启动，运行此方法
     *
     * manifest需要配置属性Agent-Class
     *
     * @param agentArgs
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("do agentmain, params: " + agentArgs);
    }
}
