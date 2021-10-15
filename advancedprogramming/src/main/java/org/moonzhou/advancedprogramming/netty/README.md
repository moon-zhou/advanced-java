## netty 示例说明

### demo001
[示例参考](https://cloud.tencent.com/developer/article/1562150)

#### 测试步骤
1. 启动服务端，开启监听：`org.moonzhou.advancedprogramming.netty.demo001.NettyServer`
2. 启动客户端，模拟发起请求：`org.moonzhou.advancedprogramming.netty.demo001.NettyClient`
3. 或者启动一个终端，使用 [netcat](https://eternallybored.org/misc/netcat) 进行连接，本示例直接使用：`nc 127.0.0.1 6668`

#### 示例说明
1. Netty 抽象出两组线程池，`BossGroup` 专门负责接收客户端连接，`WorkerGroup` 专门负责网络读写操作。
1. `NioEventLoop` 表示一个不断循环执行处理任务的线程，每个 `NioEventLoop` 都有一个 `selector`，用于监听绑定在其上的 `socket` 网络通道。
1. `NioEventLoop` 内部采用串行化设计，从消息的`读取->解码->处理->编码->发送`，始终由 IO 线程 `NioEventLoop` 负责
   ```
    NioEventLoopGroup 下包含多个 NioEventLoop
    每个 NioEventLoop 中包含有一个 Selector，一个 taskQueue
    每个 NioEventLoop 的 Selector 上可以注册监听多个 NioChannel
    每个 NioChannel 只会绑定在唯一的 NioEventLoop 上
    每个 NioChannel 都绑定有一个自己的 ChannelPipeline
   ```