package com.yp.netty.inBoundAndOutBound;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.CharsetEncoder;

/**
 * @author ex-yipeng
 * @version Id: MyClientHandler.java, v 0.1 2020/8/3 18:14 ex-yipeng Exp $
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("服务器的ip=" + ctx.channel().remoteAddress());
        System.out.println("收到服务器消息=" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");
        ctx.writeAndFlush(123456L); //发送的是一个long
        //ctx.writeAndFlush(Unpooled.copiedBuffer("fgjfjffjhyjdxdfv", CharsetUtil.UTF_8));
    }
}
