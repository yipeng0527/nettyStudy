package com.yp.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ex-yipeng
 * @version Id: GroupChatServerHandler.java, v 0.1 2020/7/22 13:41 ex-yipeng Exp $
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler {

    //定义一个channel组 管理所有channel
    /**
     * GlobalEventExecutor.INSTANCE 是全局的事件执行器 是一个单例
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //代表有channel链接上
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该channel上线推送给其他客户端
        channelGroup.writeAndFlush(sdf.format(new Date()) + "[客户端]" + channel.remoteAddress() + "加入聊天" + "\n");
        //将该channel加入到channel组中
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(sdf.format(new Date()) + "[客户端]" + channel.remoteAddress() + "离开了" + "\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(sdf.format(new Date()) + "[客户端]" + channel.remoteAddress() + "上线了" + "\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(sdf.format(new Date()) + "[客户端]" + channel.remoteAddress() + "离线了" + "\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush(sdf.format(new Date()) + "[客户]" + channel.remoteAddress() + "发送了消息" + o + "\n");
            } else {
                ch.writeAndFlush(sdf.format(new Date()) + "[自己]发送了消息" + o + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
