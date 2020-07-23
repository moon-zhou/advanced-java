/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: MultiThreadServerSocket.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/7/22 19:16
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.socket.demo003serversocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述: 手动多线程，支持多客户端连接<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MultiThreadServerSocket {

    public static void main(String[] args) {
        int port = genPort(args);

        ServerSocket server = null;
        ExecutorService service = Executors.newFixedThreadPool(5);

        try {
            server = new ServerSocket(port);
            System.out.println("server started!");
            while (true) {
                Socket socket = server.accept();

                service.execute(new ClientConnHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }

    static class ClientConnHandler implements Runnable {
        Socket socket = null;

        public ClientConnHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            try {

                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                String readMessage = null;
                while (true) {
                    System.out.println("server reading... ");
                    if ((readMessage = reader.readLine()) == null) {
                        System.out.println(Thread.currentThread().getName() + "is end.");
                        break;
                    }
                    System.out.println("server recive: " + readMessage);
                    writer.println("server recive and return: " + readMessage);
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (writer != null) {
                    writer.close();
                }
                writer = null;

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                reader = null;

                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                socket = null;

            }
        }

    }

    private static int genPort(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                return 9999;
            }
        } else {
            return 9999;
        }
    }
}
