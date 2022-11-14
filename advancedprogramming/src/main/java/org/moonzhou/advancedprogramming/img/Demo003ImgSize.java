package org.moonzhou.advancedprogramming.img;

import org.moonzhou.advancedprogramming.tryautoclose.demo003autoclose.TryWithResources;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * @author moon zhou
 * @version 1.0
 * @description: file size
 * @date 2022/11/14 16:38
 */
public class Demo003ImgSize {

    public static final int CHANGE_CONST = 1024;

    public static void main(String[] args) {

        String imgPath = "/Users/XXX/tmp/1.jpg";
        fileSize(imgPath);
        System.out.println();

        base64Size(imgPath);
    }

    public static void fileSize(String imgPath) {

        File file = new File(imgPath);
        long imgLength = file.length(); //B
        System.out.println(imgLength);
        System.out.println(toKBS(imgLength));
        System.out.println();

        try (FileInputStream fis = new FileInputStream(file)) {
            int available = fis.available(); // 注意返回int，可能文件太大导致溢出而造成值不准确
            System.out.println(available);
            System.out.println(toKBS(new Long((available))));
            System.out.println();

            FileChannel fc = fis.getChannel();
            long channelSize = fc.size();
            System.out.println(channelSize);
            System.out.println(toKBS(channelSize));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void base64Size(String imgPath) {
        String base64Img = Demo001Img2Base64String.base64Img1(new File(imgPath));
        int length = base64Img.length();
        // Base64编码要求把3个8位字节（3*8=24）转化为4个6位的字节（4*6=24），之后在6位的前面补两个0，形成8位一个字节的形式。 如果剩下的字符不足3个字节，则用0填充，输出字符使用'='，因此编码后输出的文本末尾可能会出现1或2个'='
        // 补位的'='此处未考虑，可能会造成这种情况下数据些微不准确
        int size = length - (length / 8) * 2;
        System.out.println(size);
        System.out.println(length * 0.75);
        System.out.println(toKBS(new Long(size)));
        System.out.println();
    }

    private static Double toKB(long Byte) {
        return new Double(Byte / CHANGE_CONST);
    }

    private static String toKBS(long Byte) {
        return toKB(Byte) + "KB";
    }

    private static Double toMB(long Byte) {
        return new Double(toKB(Byte) / CHANGE_CONST);
    }

    private static String toMBS(long Byte) {
        return toMB(Byte) + "MB";
    }

    private static Double toGB(long Byte) {
        return new Double(toMB(Byte) / CHANGE_CONST);
    }

    private static String toGBS(long Byte) {
        return toGB(Byte) + "GB";
    }
}
