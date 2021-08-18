### 网络编程记录
#### 核心示例说明
##### BIO
1. 简单的`ServerSocket`示例：`org.moonzhou.advancedprogramming.socket.demo001serversocket`
1. 服务端通过`ServerSocket`单线程持续获取客户端输入，客户端`Socket`连接上服务端，通过控制台输入信息，发送给服务端。示例：`org.moonzhou.advancedprogramming.socket.demo002serversocket`
1. 多线程服务端`ServerSocket`接收多线程客户端`Socket`连接。示例：`org.moonzhou.advancedprogramming.socket.demo003serversocket`
    > 服务端启动后，模拟多客户端连接，可以打开多个命令对话框，使用nc命令进行连接，或者手动启动多个client

#### 小工具
起初看到Linux可以通过`nc`命令直接连接，没有确认windows下是否支持该命令，所以直接写了Client客户端连接的代码。

后来找了下，发现windows下也可以使用，安装`NetCat`即可。步骤如下：
1. [戳我下载安装](https://eternallybored.org/misc/netcat/)
1. 安装包解压缩到你自己的相关目录
    > 网上很多文章指定目录到C:\Windows\System32，这个目的是其实是为了使用nc命令。但是不建议放到系统文件夹下。放到自己软件安装目录，同时配置环境变量也可以达到该目的。
1. 配置环境变量，配置完成直接使用`nc`命令
    * 创建环境变量`NETCAT_HOME`，值为netcat解压目录，示例：`D:\DevProgram\netcat`
    * 配置到Path里，添加`%NETCAT_HOME%`
    * 启动服务端`org.moonzhou.advancedprogramming.socket.demo002serversocket.Demo001SimpleServerSocket`，使用命令验证`nc 127.0.0.1 9999`，可以正常发送返回（一行发送，一行返回）
        ```
        λ nc 127.0.0.1 9999
        123                 
        123                
        123                
        123                
        456                
        456                
        456                
        456                
        BYE               
        BYE
        ```