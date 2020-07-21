package org.moonzhou.advancedprogramming.socket.demo001;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo001Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("启动服务器....");

            System.out.println("等待连接-阻塞");
            // 等待连接-阻塞
            Socket s = ss.accept();
            System.out.println("客户端:" + InetAddress.getLocalHost() + "已连接到服务器");
//            System.out.println("客户端:" + s.getInetAddress().getLocalHost() + "已连接到服务器");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println("等待数据过来-阻塞");
            // 读取客户端发送来的消息-阻塞
            String mess = br.readLine();
            System.out.println("客户端：" + mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(mess + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}