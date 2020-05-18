package org.moonzhou.advancedprogramming.concurrency.cyclicbarrier;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/18 16:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo002 {
    public static void main(String[] args) {

        ThreadPoolExecutor poolExe = new ThreadPoolExecutor(100, 1000, 1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(100));

        int count = 10;
        // 考试开始铃声响起，考试开始
        final CountDownLatch examBegin = new CountDownLatch(1);

        // 单个考生，考试结束交卷  +1是为了模拟最后的所有考生交卷
        final CyclicBarrier student = new CyclicBarrier(count + 1);
        /*final CyclicBarrier student = new CyclicBarrier(count, () -> {
            System.out.println("考场" + Thread.currentThread().getName() + "考试结束");
        });*/

        // 一个考场10位考生
        for (int i = 0; i < count; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("考生" + Thread.currentThread().getName() + "在等待考试开始的铃声响起");
                        examBegin.await();
                        System.out.println("考生听到铃声" + Thread.currentThread().getName() + "开始答题");
                        Thread.sleep((long) (Math.random() * 100));//答题过程，真正的业务逻辑处理部分
                        System.out.println("考生" + Thread.currentThread().getName() + "交卷");
                        student.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            poolExe.execute(runnable); // 运动员开始任务
        }

        try {
            // 答题时间
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("考场" + Thread.currentThread().getName() + "开始铃声即将响起");
            examBegin.countDown();
            System.out.println("考场" + Thread.currentThread().getName() + "考试开始铃声响起");

            // 所有考生交卷
            student.await();
            System.out.println("考场" + Thread.currentThread().getName() + "考试结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        poolExe.shutdown();

    }
}
