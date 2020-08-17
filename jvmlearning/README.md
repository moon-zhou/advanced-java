### JVM学习模块
> 用于记录JVM学习过程中的知识点，以及相关示例

#### 缓存行
1. 为什么会有缓存行的问题？
    > 因为CPU的运算速度远比内存要快，为了减少访问内存的次数，缓存应运而生（L1/L2/L3）。而且通常读取了一块数据，其后面的数据通常也会被使用到，所以每一次缓存的数据单位为一个缓存行。
    > 
    > 缓存行是2的整数幂个连续字节，一般为32-256个字节。最常见的缓存行大小是64个字节。
    >
    > 当多线程修改互相独立的变量时，如果这些变量共享同一个缓存行，就会无意中影响彼此的性能，这就是伪共享。

1. CPU到各组件获取数据的访问速度

    | 从CPU到 | 大约需要的 CPU 周期 | 大约需要的时间 |
    | ----- | ----: | :----: |
    | 寄存器 | 1 cycle | - |
    | L1 cache | 约3-4 cycles | 约1ns |
    | L2 cache | 约10 cycles | 约3ns |
    | L3 cache | 约40-45 cycles | 约15ns |
    | QPI 总线传输(between sockets, not drawn) | - | 约20ns |
    | 主存 | - | 约60-80纳秒 |

1. 伪共享问题
    1. 什么是伪共享？
        * 当多线程修改互相独立的变量时，如果这些变量共享同一个缓存行
    1. 如何避免伪共享？

#### 小工具
1. 使用JOL(Java Object Layout)查看java对象的内存布局
    1. 引入依赖
        ```java
         <dependency>
            <groupId>org.openjdk.jol</groupId>
            <artifactId>jol-core</artifactId>
            <version>0.11</version>
        </dependency>
        ```
    1. 使用
    
#### 参考
1. 缓存行
    * [CPU缓存行](https://my.oschina.net/manmao/blog/804161)