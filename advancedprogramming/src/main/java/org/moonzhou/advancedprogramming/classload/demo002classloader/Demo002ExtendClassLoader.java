package org.moonzhou.advancedprogramming.classload.demo002classloader;

import lombok.extern.slf4j.Slf4j;
import sun.security.util.CurveDB;

/**
 * @author moon zhou
 * @version 1.0
 * @description: extend class loader
 * @date 2023/2/7 10:54
 */
@Slf4j
public class Demo002ExtendClassLoader {

    public static void main(String[] args) {
        log.info("****** start extend class loader ******");

        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(":")) {
            log.info(path);
        }

        ClassLoader classLoader = CurveDB.class.getClassLoader();
        // System.out.println(classLoader);
        log.info(String.valueOf(null == classLoader));

    }
}
