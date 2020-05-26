package org.moonzhou.advancedprogramming.concurrency.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * fork-join 累加计算示例<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/26 12:04
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2; // 子任务里进行相加的阈值

    /**
     * 子任务里，累加的开始值和结束值
     */
    private int start;
    private int end;

    public Demo001CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小，就开始进行任务计算
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务，再进行计算（可能子任务还不满足阈值，还需要再进行拆分，这是一个递归的过程）
            int middle = (start + end) / 2;
            Demo001CountTask leftTask = new Demo001CountTask(start, middle);
            Demo001CountTask rightTask = new Demo001CountTask(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完，并得到器结果
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();

            // 合并子任务
            sum = leftResult + rightResult;
        }

        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算任务： 1+2+3+4
        Demo001CountTask task = new Demo001CountTask(1, 5);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
