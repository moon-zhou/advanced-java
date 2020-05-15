package org.moonzhou.common;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * 计时功能<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/15 15:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Timing {

    public static void main(String[] args) {
        initialMethod();

        try {
            guavaMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void initialMethod() {
        System.out.println();

        long start = System.currentTimeMillis();   //获取开始时间

        // 模拟其他代码执行
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： " + (end - start) + "ms");
    }

    private static void guavaMethod() throws InterruptedException {
        System.out.println();

        // 创建之后立刻计时，若想主动开始计时
        Stopwatch stopwatch = Stopwatch.createStarted();
        // 创建计时器，但是需要主动调用 start 方法开始计时
        // Stopwatch stopwatch = Stopwatch.createUnstarted();
        // stopWatch.start();
        // 模拟其他代码耗时
        TimeUnit.SECONDS.sleep(2L);

        // 当前已经消耗的时间
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

        TimeUnit.SECONDS.sleep(2L);

        // 停止计时 未开始的计时器调用 stop 将会抛错 IllegalStateException
        stopwatch.stop();

        // 再次统计总耗时
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
        // 重新开始，将会在原来时间基础计算，若想重新从 0开始计算，需要调用 stopwatch.reset()

        stopwatch.start();
        TimeUnit.MILLISECONDS.sleep(1500L);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        stopwatch.reset();
        stopwatch.start();
        TimeUnit.MILLISECONDS.sleep(1500L);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

    }
}
