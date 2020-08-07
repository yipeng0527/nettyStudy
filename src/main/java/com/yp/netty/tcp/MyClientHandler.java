package com.yp.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.Charset;

/**
 * @author ex-yipeng
 * @version Id: MyClientHandler.java, v 0.1 2020/8/7 14:44 ex-yipeng Exp $
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        for (int i = 0; i < 10; i++) {
            String msg = "hi " + (i + 1) + " 我是乐多,你养我啊";
            ByteBuf requestMsg = Unpooled.copiedBuffer(msg, Charset.forName("utf-8"));
            channel.writeAndFlush(requestMsg);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        String responseMsg = new String(buffer, Charset.forName("utf-8"));
        System.out.println("服务器返回消息:" + responseMsg);
        System.out.println("服务器第" + (++count) + "次返回");
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
