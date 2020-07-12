### 负载均衡
#### 设备角度
1. 硬件负载
1. 软件负载

#### 技术角度
1. 服务端负载均衡
1. 客户端负载均衡

### 负载均衡算法
1. 随机
    * 简单随机：Demo001SimpleRandomLoadBalance
    * 加权随机
        * 简单加权随机：Demo002SimpleWeightRandomLoadBalance
        * 偏移量算法加权随机：Demo003OffsetWeightRandomLoadBalance
2. 轮询
    * 简单轮询（线程安全与否）
        1. Demo004SimpleRoundRobinLoadBalance
        1. Demo005SimpleThreadSafeRoundRobinLoadBalance
        1. Demo006SimpleThreadSafeRoundRobinLoadBalance
    * 加权轮询轮询（线程与否）
        1. Demo007OffsetWeightRoundRobinLoadBalance
        1. Demo008ThreadSafeOffsetWeightRoundRobinLoadBalance
    * 平滑加权轮询：示例里线程不安全
        1. Demo009WeightSmoothRoundRobinLoadBalance
3. 哈希：Demo010HashLoadBalance  
    “相同的请求尽可能落到同一个服务器上”。“相同的请求” — 什么是相同的请求？一般在使用一致性哈希负载均衡时，需要指定一个 key 用于 hash 计算，可能是
    1. 请求方 IP
    1. 请求服务名称，参数列表构成的串
    1. 用户 ID
4. 最小压力  
选择一台当前最“悠闲”的服务器，如果A服务器有100个请求，B服务器有5个请求，而C服务器只有3个请求，那么毫无疑问会选择C服务器，这种负载均衡算法是比较科学的。

<p>
在实际的负载均衡下，可能会将多个负载均衡算法合在一起实现，比如先根据最小压力算法，当有几台服务器的压力一样小的时候，再根据权重取出一台服务器，如果权重也一样，再随机取一台，等等。

### 参考
1. [浅谈负载均衡算法与实现](https://juejin.im/post/5c827b1e6fb9a049ff4eed25)
1. [一致性哈希负载均衡算法的探讨](https://juejin.im/post/5c7c87c351882549664afe7f)