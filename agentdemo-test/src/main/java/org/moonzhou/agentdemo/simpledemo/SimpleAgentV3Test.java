package org.moonzhou.agentdemo.simpledemo;


import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description agent测试main方法类，因为agent未抽取成不同的module，所以需要注意测试时，修改相关配置重新打对应的jar包
 * 注意run configuration的VM options：
 *     <code>-javaagent:E:/CodeSpace/Workspaces/IdeaProjects/advanced-java/agentdemo/target/agentdemo-1.0-SNAPSHOT.jar=moon<code/>
 * @date 2020/3/21 15:30
 * @since 1.0
 */
public class SimpleAgentV3Test {
    public static void main(String[] args)
            throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("SimpleAgentV3Test")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                virtualMachine.loadAgent("E:/CodeSpace/Workspaces/IdeaProjects/advanced-java/agentdemo/target/agentdemo-1.0-SNAPSHOT.jar", "moon is handsome.");
                System.out.println("ok");

                virtualMachine.detach();
            }
        }

        // 用jps -l 查出目标应用的进程号，替换下面的参数
//        VirtualMachine vm = VirtualMachine.attach("36633");
        // 用你自己的agent绝对地址替换
//        vm.loadAgent("/Users/user/Project/GitHub/study-demo/java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }
}
