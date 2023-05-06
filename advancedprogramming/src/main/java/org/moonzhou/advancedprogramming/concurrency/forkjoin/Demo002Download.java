package org.moonzhou.advancedprogramming.concurrency.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author moon zhou
 * @version 1.0
 * @description: fork join download file
 * @date 2023/4/17 10:34
 */
@Slf4j
public class Demo002Download {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "https://example.com/file1.txt",
                "https://example.com/file2.txt",
                "https://example.com/file3.txt",
                "https://example.com/file4.txt",
                "https://example.com/file5.txt"
        );
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new DownloadAction(urls, 0, urls.size()));
        log.info("file download completed!");
    }

    static class DownloadAction extends RecursiveAction {

        private List<String> urls;
        private int start;
        private int end;

        public DownloadAction(List<String> urls, int start, int end) {
            this.urls = urls;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <=1) {
                // log can be replaced by HttpUtil in actual code
                log.info("exit: download {}.", urls.get(start));
                return;
            }

            int mid = (start + end) / 2;
            DownloadAction leftAction = new DownloadAction(urls, start, mid);
            DownloadAction rightAction = new DownloadAction(urls, mid, end);
            invokeAll(leftAction, rightAction);
        }
    }
}