package org.moonzhou.advancedprogramming.socket.demo002serversocket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo002SimpleSocketClient {

    /**
     * 退出监听关键字
     */
    private static final String EXIT_KEY_WORD = "BYE";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("连接上：" + socket);

        //构建IO
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        Scanner input = new Scanner(System.in);

        while (true) {

            String sendMessage = input.nextLine();

            System.out.println("控制台输入：" + sendMessage);

            /*
             * 向服务器端发送一条消息
             *
             * 控制台输入的数据被读取之后，会去掉\r\n，
             * 而ServerSocket的readLine()方法在进行读取一行时，只有遇到回车(\r)或者换行符(\n)才会返回读取结果，必须要有\r\n
             * readLine()返回的读取内容中并不包含换行符或者回车符
             */
            bw.write(sendMessage + "\r\n");
            bw.flush();

            // 读取服务器返回的消息
            String resultMessage = br.readLine();
            System.out.println("服务器返回：" + resultMessage);

            if (EXIT_KEY_WORD.equals(sendMessage)) {
                System.out.println("exit...");
                break;
            }
        }

        bw.close();
        br.close();

        os.close();
        is.close();

        input.close();
    }
}