/*
 * Copyright (C), 2002-2021, moon-zhou
 * FileName: DiscardServerHandler.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2021/10/15 11:24
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.advancedprogramming.netty.demo002;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * 功能描述: netty 官方第一个示例 DISCARD <br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        // Discard the received data silently
        // ((ByteBuf) msg).release();

        // ByteBuf是一个引用计数对象实现ReferenceCounted，他就是在有对象引用的时候计数+1，无的时候计数-1，当为0对象释放内存
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();

//                System.out.println(in.toString(CharsetUtil.UTF_8)); // 如上两句也可以使用此方式
            }
        } finally {
            // ByteBuf is a reference-counted object which has to be released explicitly via the release() method.
            // Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler.
            ReferenceCountUtil.release(msg);

//            in.release(); // 或者使用此方式
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
