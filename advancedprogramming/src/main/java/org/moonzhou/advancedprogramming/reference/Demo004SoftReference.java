package org.moonzhou.advancedprogramming.reference;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 软引用示例demo<br>
 * 运行时请设置JVM参数：
 * <code>-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails</code>
 *
 * <p>当GC的时候，如果GC Root可达，如果内存足够，就不会被回收；如果内存不够用，会被回收。</p>
 *
 * 软引用的常见用途就呼之欲出了：缓存。尤其是那种希望这个缓存能够持续时间长一点的。
 *
 * 参考：https://juejin.im/post/5ec3c4aae51d45788a6d4e33
 *
 * @author moon-zhou
 * @date 2020/5/27 08:58
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo004SoftReference {

    public static void main(String[] args) {
        List<Object> list = new LinkedList<Object>();
        for (int i = 0; i < 21; i++) {
            // 与Demo003StrongReference比较，此时就不会出现OOM
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024]);
            list.add(softReference);
        }
    }

}
