##### java agent实操记录

1. 编写agent处理类
1. 打jar包，注意配置（此示例使用maven）
1. 运行测试（idea run configuration 的VM options需要添加）
   ```
   # 注意jar包路径是全路径，且agent后的冒号与后面的值不能有空格，否则报错
   Error occurred during initialization of VM
   Error opening zip file or JAR manifest missing : 
   agent library failed to init: instrument
   
   -javaagent:E:/CodeSpace/Workspaces/IdeaProjects/advanced-java/agentdemo/target/agentdemo-1.0-SNAPSHOT.jar=moon
   ```
1. 如果使用命令，注意编码
    ```
    javac -encoding utf-8
    ```
