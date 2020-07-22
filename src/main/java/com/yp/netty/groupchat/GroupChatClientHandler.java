package com.yp.netty.groupchat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author ex-yipeng
 * @version Id: GroupChatClientHandler.java, v 0.1 2020/7/22 15:00 ex-yipeng Exp $
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println(o.toString().trim());
    }
}
