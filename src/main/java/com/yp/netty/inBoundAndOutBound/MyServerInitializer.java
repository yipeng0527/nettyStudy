package com.yp.netty.inBoundAndOutBound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ex-yipeng
 * @version Id: MyServerInitializer.java, v 0.1 2020/8/3 14:51 ex-yipeng Exp $
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decode", new MyByteToLongDecoder());
        pipeline.addLast(new MyServerHandler());
    }
}
