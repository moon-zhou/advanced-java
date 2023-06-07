package org.moonzhou.dailyprogramming.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author moon zhou
 * @version 1.0
 * @description: file test
 * @date 2023/6/7 15:39
 */
@Slf4j
public class FileDemo001 {
    public static void main(String[] args) {
        // user.dir 当前项目的根目录
        // String testBasePath = System.getProperty("user.dir") + File.separator + "tmp" + File.separator;
        // 当前用户目录
        String testBasePath = System.getProperty("user.home") + File.separator + "tmp" + File.separator;
        File testBaseFolder = new File(testBasePath);
        log.info("base path: {}, file exist: {}", testBasePath, String.valueOf(testBaseFolder.exists()));

        File testFolder = new File(testBasePath, "test");
        log.info("test folder path: {}, exist: {}", testFolder.getAbsolutePath(), testFolder.exists());
        if (testFolder.exists()) {
            String[] list = testFolder.list();
            Arrays.stream(list).forEach(System.out::println);
        }

        log.info("test Paths.get: {}", Paths.get(testBasePath, "test"));
        log.info("test Paths.get: {}", Paths.get(testBasePath, "test", "img"));

        Path testImgFolder = Paths.get(testBasePath, "test", "img");
        Path testUnderTestImg = testImgFolder.resolve("test");
        log.info("test img folder path: {}, absolute path: {}", testImgFolder, testImgFolder.toAbsolutePath());
        log.info("test under test img folder path: {}, absolute path: {}", testUnderTestImg, testUnderTestImg.toAbsolutePath());



    }
}
