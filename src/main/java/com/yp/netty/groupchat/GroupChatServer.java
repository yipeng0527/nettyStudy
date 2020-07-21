package com.yp.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by pp on 2020/7/21.
 */
public class GroupChatServer {

    private int port;

    private static ChannelGroup channelGroup;

    public GroupChatServer(int port) {
        this.port = port;
    }

    private void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup, workerGroup);
    }

    public static void main(String[] args) {
        new GroupChatServer(9888).start();
    }
}
