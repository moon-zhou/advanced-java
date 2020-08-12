### JVM学习模块
> 用于记录JVM学习过程中的知识点，以及相关示例

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