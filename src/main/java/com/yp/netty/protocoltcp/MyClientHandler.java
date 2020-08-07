package com.yp.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author ex-yipeng
 * @version Id: MyClientHandler.java, v 0.1 2020/8/7 14:44 ex-yipeng Exp $
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        for (int i = 0; i < 10; i++) {
            String msg = "hi " + (i + 1) + " 我是乐多,你养我啊";
            MessageProtocol sendMsg = new MessageProtocol();
            sendMsg.setLength(msg.getBytes(Charset.forName("utf-8")).length);
            sendMsg.setContent(msg.getBytes(Charset.forName("utf-8")));
            channel.writeAndFlush(sendMsg);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol msg) throws Exception {
        String responseMsg = new String(msg.getContent(), Charset.forName("utf-8"));
        System.out.println("服务器返回消息:" + responseMsg);
        System.out.println("服务器第" + (++count) + "次返回");
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
