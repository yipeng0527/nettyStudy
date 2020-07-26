package com.yp.netty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
/**
 * @author ex-yipeng
 * @version Id: GroupChatClientHandler.java, v 0.1 2020/7/22 15:00 ex-yipeng Exp $
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        System.out.println(msg.trim());
    }
}
