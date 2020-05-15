package org.moonzhou.ioutils;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/15 14:17
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001 {

    public static void main(String[] args) {

        /**
         * IOUtils可以适用于一个比较试用的场景，比如支付场景下，HTTP 异步通知场景。如果我们使用 JDK 原生方法写:
         * 从 Servlet 获取异步通知内容
         */

        /*byte[] b = null;
        ByteArrayOutputStream baos = null;
        String respMsg = null;
        try {
            byte[] buffer = new byte[1024];
            baos = new ByteArrayOutputStream();
            // 获取输入流
            InputStream in = request.getInputStream();
            for (int len = 0; (len = in.read(buffer)) > 0; ) {
                baos.write(buffer, 0, len);
            }
            b = baos.toByteArray();
            baos.close();
            // 字节数组转化成字符串
            String reqMessage = new String(b, "utf-8");
        } catch (IOException e) {

        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {

                }
            }
        }*/

        // 工具替换方法
        // 将输入流信息全部输出到字节数组中
//        byte[] b = IOUtils.toByteArray(request.getInputStream());
        // 将输入流信息转化为字符串
//        String resMsg = IOUtils.toString(request.getInputStream());

    }
}
