package com.yp.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author ex-yipeng
 * @version Id: MyServerHandler.java, v 0.1 2020/8/7 13:55 ex-yipeng Exp $
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext cx, MessageProtocol msg) throws Exception {

        String requestMsg = new String(msg.getContent(), Charset.forName("utf-8"));
        System.out.println("接收到客户端消息:" + requestMsg);
        System.out.println("第" + (++count) + "次接收到客户端消息");

        String sendMsg = UUID.randomUUID().toString() + " ";
        MessageProtocol responseMsg = new MessageProtocol();
        responseMsg.setLength(sendMsg.getBytes(Charset.forName("utf-8")).length);
        responseMsg.setContent(sendMsg.getBytes(Charset.forName("utf-8")));
        cx.channel().writeAndFlush(responseMsg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
