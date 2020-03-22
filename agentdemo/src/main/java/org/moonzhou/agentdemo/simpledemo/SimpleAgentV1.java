package org.moonzhou.agentdemo.simpledemo;

import java.lang.instrument.Instrumentation;

/**
 * @description java agent first simple demo
 *     第一个优先级高；参数只能是一个string，如果多个参数，需要agent自己定义规范并解析
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

    public static void premain(String agentArgs) {
        System.out.println("premain start, no instrumentation...");

        System.out.println(agentArgs);
    }
}
