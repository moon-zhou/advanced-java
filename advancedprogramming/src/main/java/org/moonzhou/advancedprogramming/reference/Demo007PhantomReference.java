package org.moonzhou.advancedprogramming.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用示例demo<br>
 * <p>虚引用的设计和上面三种引用有些不同，它并不影响GC，而是为了在对象被GC时，能够收到一个系统通知。</p>
 * <p>虚引用必须要配合ReferenceQueue，当GC准备回收一个对象，如果发现它还有虚引用，就会在回收之前，把这个虚引用加入到与之关联的ReferenceQueue中。</p>
 *
 * @author moon-zhou
 * @date 2020/5/27 19:56
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo007PhantomReference {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue queue = new ReferenceQueue ();
        PhantomReference<Object> pf = new PhantomReference<Object>(obj, queue);
        obj=null;

        while(true){
            System.out.printf("pf.get() = %d, isEnqueued: %b\r\n", pf.get(), pf.isEnqueued());
            if(pf.isEnqueued())
                break;
            System.gc();
            Thread.sleep(1000);
        }
    }
}
