/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: NettyServerHandler.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/10/14 11:52
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.netty.demo001;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 功能描述: netty示例-服务端Handler<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送来的数据
     *
     * @param ctx ChannelHandler的上下文对象 有管道 pipeline 通道 channel 和 请求地址 等信息
     * @param msg 客户端发送的具体数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端请求到了..." + ctx.channel().remoteAddress());
        ByteBuf buf = (ByteBuf) msg;

        System.out.println("客户端发送的数据是:" + buf.toString(CharsetUtil.UTF_8));

    }

    /**
     * 读取客户端发送数据完成后的方法
     * 在本方法中可以发送返回的数据
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是组合方法
        // \n 保证客户端终端文案显示时自动换行
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好啊，客户端....^_^" + "\n", CharsetUtil.UTF_8));
    }
}
