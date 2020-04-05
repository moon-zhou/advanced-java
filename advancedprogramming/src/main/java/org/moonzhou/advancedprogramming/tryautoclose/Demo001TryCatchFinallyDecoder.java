package org.moonzhou.advancedprogramming.tryautoclose;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * 最初try-catch-finally使用
 *
 * https://juejin.im/post/5e87cb9be51d4546cf777342
 *
 * @author moon-zhou <ayimin1989@163.com>
 * @version V1.0.0
 * @description
 * @date 2020/4/4 22:28
 * @since 1.0
 */
public class Demo001TryCatchFinallyDecoder {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            /*
             * 可以使用绝对路径，但是不符合实际配置，实际配置在resources目录下，最终打包是到classes目录下
             *
             * 如果使用相对路径，直接new FileReader("/考研资料.txt")，该初始化方式要求文件在src目录下，也与实际配置不符
             */
            String path = Demo001TryCatchFinallyDecoder.class.getResource("/考研资料.txt").getFile();
            String decodePath = URLDecoder.decode(path,"utf-8");
            br = new BufferedReader(new FileReader(decodePath));

            String str = null;
            while ((str =br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
