package org.moonzhou.advancedprogramming.classload.demo002classloader;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

/**
 * @author moon zhou
 * @version 1.0
 * @description: test classloader
 * @date 2023/2/7 10:41
 */
@Slf4j
public class Demo001ClassLoaderTest01 {
    public static void main(String[] args) {
        log.info("****** start class loader ******");

        // BootstrapClassLoader能够加载的api路径
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            log.info(url.toExternalForm());
        }

        // 从上面的路径中随意选择一个类，看看类加载器是什么：引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        // 为null表示启动类加载器
        // System.out.println(classLoader);
        log.info(String.valueOf(null == classLoader));
    }
}
