package org.moonzhou.advancedprogramming.img;

import org.springframework.util.Base64Utils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Base64;

/**
 * @author moon zhou
 * @version 1.0
 * @description: convert img file to base64 string
 * @date 2022/11/9 13:56
 */
public class Demo001Img2Base64String {

    public static void main(String[] args) {

        File img = new File("/Users/XXX/tmp/1.jpg");
        try (InputStream imgStream = new FileInputStream(img);) {
            String imgBase64 = getBase64FromInputStream(imgStream);
            System.out.println("img base64 string is: \n" + imgBase64);
        } catch (Exception e) {
            System.err.println("error: ");
        }
    }

    public static String base64Img1(File img) {
        try (InputStream imgStream = new FileInputStream(img);) {
            byte[] data = getBytes(imgStream);

            return Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            System.err.println("error: ");
        }

        return null;
    }

    public static String base64Img2(File img) {
        try (InputStream imgStream = new FileInputStream(img);) {
            byte[] data = getBytes(imgStream);

            return Base64.getMimeEncoder().encodeToString(data);
        } catch (Exception e) {
            System.err.println("error: ");
        }

        return null;
    }


    public static String base64Img3(File img) {
        try (InputStream imgStream = new FileInputStream(img);) {
            byte[] data = getBytes(imgStream);

            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(data);
        } catch (Exception e) {
            System.err.println("error: ");
        }

        return null;
    }

    private static String getBase64FromInputStream(InputStream is) {
        byte[] data = getBytes(is);

        String temp1 = Base64.getEncoder().encodeToString(data);
        String temp2 = Base64Utils.encodeToString(data);
        String temp3 = Base64.getMimeEncoder().encodeToString(data);
        String temp4 = temp3.replaceAll("\r\n", "");

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String temp5 = base64Encoder.encode(data);
        String temp6 = temp5.replaceAll("\n", "");

        System.out.println(temp1.equals(temp2)); // true
        System.out.println(temp2.equals(temp3)); // false
        System.out.println(temp2.equals(temp4)); // true
        System.out.println(temp1.equals(temp5)); // false
        System.out.println(temp1.equals(temp6)); // true

        // return temp1;
        return temp3;
    }

    private static byte[] getBytes(InputStream is) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;

        // 读取图片字节数组
        try (ByteArrayOutputStream swapStream = new ByteArrayOutputStream();) {

            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = is.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (Exception e) {
            System.err.println("img to base64 string error: ");
        }
        return data;
    }
}
