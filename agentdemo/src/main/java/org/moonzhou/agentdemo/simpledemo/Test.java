package org.moonzhou.agentdemo.simpledemo;

import java.util.concurrent.TimeUnit;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description agent测试main方法类
 * @date 2020/3/21 15:30
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("test agent, main method run start...");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("test agent, main method run end...");
    }
}
