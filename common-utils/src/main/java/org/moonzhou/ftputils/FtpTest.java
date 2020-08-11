package org.moonzhou.ftputils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * 计时功能<br>
 * 〈功能详细描述〉
 *
 * @author moon-zhou
 * @date 2020/5/15 15:02
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FtpTest {

    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        InputStream input = null;
        try {
            ftpClient.connect("10.19.38.5", 21);
            boolean loginResult = ftpClient.login("test", "1qaz@WSX");
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return;
            }

            input = ftpClient.retrieveFileStream("test.png");

            FTPFile[] ftpFiles = ftpClient.listFiles();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != input) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                ftpClient.logout();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*String waterMarkContent = "sn17010111";
        byte[] data = ImageAddWaterMarkUtil.addWatermarkTransByte(input, null, waterMarkContent);

        IOUtils.write(data, resp.getOutputStream());*/

    }
}
