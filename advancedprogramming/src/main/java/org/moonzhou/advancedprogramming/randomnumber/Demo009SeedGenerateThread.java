package org.moonzhou.advancedprogramming.randomnumber;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * thread
 * @author moon zhou
 */
public class Demo009SeedGenerateThread {

    static class SearchTask implements Callable<Long> {

        private final char[] goal;
        private final long start, step;

        public SearchTask(final String goal, final long offset, final long step) {
            final char[] goalAsArray = goal.toCharArray();
            this.goal = new char[goalAsArray.length + 1];
            System.arraycopy(goalAsArray, 0, this.goal, 0, goalAsArray.length);
            this.start = Long.MIN_VALUE + offset;
            this.step = step;
        }

        @Override
        public Long call() throws Exception {
            final long LIMIT = Long.MAX_VALUE - this.step;
            final Random random = new Random();
            int position, rnd;
            long seed = this.start;

            while ((Thread.interrupted() == false) && (seed < LIMIT)) {
                random.setSeed(seed);
                position = 0;
                rnd = random.nextInt(27);
                while (((rnd == 0) && (this.goal[position] == 0))
                        || ((char) ('`' + rnd) == this.goal[position])) {
                    ++position;
                    if (position == this.goal.length) {
                        return seed;
                    }
                    rnd = random.nextInt(27);
                }
                seed += this.step;
            }

            throw new Exception("No match found");
        }
    }

    public static void main(String[] args) {
        final String GOAL = "hello".toLowerCase();
        final int NUM_CORES = Runtime.getRuntime().availableProcessors();

        final ArrayList<SearchTask> tasks = new ArrayList<>(NUM_CORES);
        for (int i = 0; i < NUM_CORES; ++i) {
            tasks.add(new SearchTask(GOAL, i, NUM_CORES));
        }

        final ExecutorService executor = Executors.newFixedThreadPool(NUM_CORES, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                final Thread result = new Thread(r);
                result.setPriority(Thread.MIN_PRIORITY); // make sure we do not block more important tasks
                result.setDaemon(false);
                return result;
            }
        });
        try {
            final Long result = executor.invokeAny(tasks);
            System.out.println("Seed for \"" + GOAL + "\" found: " + result);
        } catch (Exception ex) {
            System.err.println("Calculation failed: " + ex);
        } finally {
            executor.shutdownNow();
        }
    }
}
