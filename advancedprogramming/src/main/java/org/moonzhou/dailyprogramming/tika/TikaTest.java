package org.moonzhou.dailyprogramming.tika;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

/**
 * @author moon zhou
 * @version 1.0
 * @description Tika test
 * @date 2022/11/10 17:00
 */
public class TikaTest {
    public static void main(String[] args) throws IOException {
        // commons-io 使用最新版本，过低的版本会有异常g
        Tika tika = new Tika();
        String mimeType = tika.detect(new File("/Users/XXX/tmp/1.jpg"));

        // image/jpeg
        System.out.println(mimeType);
    }
}
