/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: Demo001SimpleServerSocket.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/21 17:20
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.socket.demo002serversocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能描述: ServerSocket简单使用的例子<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Demo001SimpleServerSocket {

    /**
     * 退出监听关键字
     */
    private static final String EXIT_KEY_WORD = "BYE";

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("开始： " + server);

        // 等待连接-阻塞，只会连接一个客户端
        System.out.println("等待客户端连接-阻塞");
        Socket socket = server.accept();
        System.out.println("Connection socket: " + socket);

        BufferedReader in = null;
        try {
            while (true) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Output is automatically flushed by PrintWrite
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                // 等待读取数据-阻塞
                System.out.println("等待读取数据-阻塞");
                String str = in.readLine();
                System.out.println("接收到客户端数据: " + str);
                out.println(str);

                if (EXIT_KEY_WORD.equals(str)) {
                    break;
                }

            }

        } finally {
            System.out.println("CLosing....");
            in.close();
            socket.close();
        }
    }
}
