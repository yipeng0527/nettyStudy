package com.yp.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by pp on 2020/7/26.
 */
public class ChatClient {
    private final String host;

    private final int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void run() throws Exception {
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();

        try {
            Bootstrap client = new Bootstrap();
            client.group(clientGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(null);
                        }
                    });

            ChannelFuture channelFuture = client.bind(host, port).sync();
            System.out.println(channelFuture.channel().localAddress() + "启动成功......");
        } finally {
            clientGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatClient("127.0.0.1", 8889).run();
    }
}
