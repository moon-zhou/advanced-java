/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NettyClient.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/10/14 14:13
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.netty.demo001;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NettyClient {
    public static void main(String[] args) {
        // 客户端就只需要创建一个 线程组了
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        // 创建 启动器
        Bootstrap bootstrap = new Bootstrap();
        try {
            // 设置相关的参数
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            // 连接服务
            ChannelFuture future = bootstrap.connect("localhost", 6668).sync();
            // 对服务关闭 监听
            future.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            loopGroup.shutdownGracefully();
        }

    }
}
