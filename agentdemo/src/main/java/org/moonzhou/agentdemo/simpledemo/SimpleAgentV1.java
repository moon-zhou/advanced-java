package org.moonzhou.agentdemo.simpledemo;

import java.lang.instrument.Instrumentation;

/**
 * @description java agent first simple demo，只包含单个参数
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @since 1.0
 * @date 2020/3/21
 */
public class SimpleAgentV1 {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain start...");

        System.out.println(agentArgs);
    }
}
