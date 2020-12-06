#### 奇偶交替打印

使用两个线程，一个打印奇数一个打印偶数，如何保证交替答应。

```java
实现方案1：
org.moonzhou.practice.demo004OldEvenPrintByTurn.PrintOldEvenAtomic

实现方案2
org.moonzhou.practice.demo004OldEvenPrintByTurn.PrintOldEvenVolatile
```
以上两种没有使用线程间交互，只是利用了while以及if，利用就只能进其中一个判断条件，从而变向的时间了执行的串行化。
剩下的就是保证保证操作数的线程可见性即可。


```java

实现方案3
org.moonzhou.practice.demo004OldEvenPrintByTurn.PrintOldEvenWaitNotify
```
方案3区别于方案1和2，有通过synchronized串行化，并结合wait/notify来进行线程间的交替执行。