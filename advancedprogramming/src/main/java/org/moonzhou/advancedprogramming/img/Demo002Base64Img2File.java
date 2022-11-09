package org.moonzhou.advancedprogramming.img;

import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.Base64;

/**
 * @author moon zhou
 * @version 1.0
 * @description: base64 img convert to img file
 * @date 2022/11/9 14:22
 */
public class Demo002Base64Img2File {

    /**
     * 生成图片文件夹地址
     */
    private static final String IMG_SAVE_PATH = "/Users/XXX/tmp/";

    public static void main(String[] args) {

        // 注意解码的方法必须与编码的方法相对应，否则会报错。
        String base64Img1 = Demo001Img2Base64String.base64Img1(new File("/Users/XXX/tmp/1.jpg"));
        String base64Img2 = Demo001Img2Base64String.base64Img2(new File("/Users/XXX/tmp/1.jpg"));
        String base64Img3 = Demo001Img2Base64String.base64Img3(new File("/Users/XXX/tmp/1.jpg"));

        System.out.println(generateImg1(base64Img1, "tmp-001.jpg"));
        System.out.println(generateImg2(base64Img2, "tmp-002.jpg"));
        System.out.println(generateImg3(base64Img3, "tmp-003.jpg"));
    }

    private static boolean generateImg1(String base64str, String fileName) {
        try {
            byte[] data = Base64.getDecoder().decode(base64str);

            generateImg(fileName, data);

            return true;
        } catch (Exception e) {
            System.err.println("generateImg1 error.");
        }

        return false;
    }

    private static boolean generateImg2(String base64str, String fileName) {
        try {
            byte[] data = Base64.getMimeDecoder().decode(base64str);

            generateImg(fileName, data);

            return true;
        } catch (Exception e) {
            System.err.println("generateImg2 error.");
        }

        return false;
    }

    private static boolean generateImg3(String base64str, String fileName) {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] data = base64Decoder.decodeBuffer(base64str);

            generateImg(fileName, data);

            return true;
        } catch (Exception e) {
            System.err.println("generateImg3 error.");
        }

        return false;
    }

    private static void generateImg(String fileName, byte[] data) {
        try(OutputStream out = new FileOutputStream(IMG_SAVE_PATH + fileName);) {

            for (int i = 0; i < data.length; ++i) {
                if (data[i] < 0) {// 调整异常数据
                    data[i] += 256;
                }
            }

            out.write(data);
            out.flush();
        } catch (Exception e) {
            System.err.println("decode error.");
        }
    }
}
