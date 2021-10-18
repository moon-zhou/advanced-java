/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: EchoServerHandler.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/10/18 9:36
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.netty.demo003;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 功能描述:<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 官网说明：
     * A ChannelHandlerContext object provides various operations that enable you to trigger various I/O events and operations.
     * Here, we invoke write(Object) to write the received message in verbatim.
     * Please note that we did not release the received message unlike we did in the DISCARD example.
     * It is because Netty releases it for you when it is written out to the wire.
     *
     * ctx.write(Object) does not make the message written out to the wire.
     * It is buffered internally and then flushed out to the wire by ctx.flush().
     * Alternatively, you could call ctx.writeAndFlush(msg) for brevity.
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        // ChannelHandlerContext提供各种不同的操作用于触发不同的I/O时间和操作
        // 调用write方法来逐字返回接收到的信息
        // 这里我们不需要在DISCARD例子当中那样调用释放，因为Netty会在写的时候自动释放
        // 只调用write是不会释放的，它会缓存，直到调用flush
//        ctx.write(msg);
//        ctx.flush();

        // 你可以直接使用writeAndFlush(msg)
        // ctx.writeAndFlush(msg);

        ByteBuf in = (ByteBuf) msg;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
//                .addListener(ChannelFutureListener.CLOSE); // 收到一条消息后就关闭了与之连接的客户端
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
