package org.moonzhou.dailyprogramming.lambda.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Demo001ParallelStreamExample {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
            "https://example.com/file1.txt", 
            "https://example.com/file2.txt", 
            "https://example.com/file3.txt", 
            "https://example.com/file4.txt", 
            "https://example.com/file5.txt"
        );
        urls.parallelStream().forEach(url -> log.info(url));

        log.info("download completed");
    }
}