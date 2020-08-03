package com.yp.netty.inBoundAndOutBound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ex-yipeng
 * @version Id: MyClientInitializer.java, v 0.1 2020/8/3 18:08 ex-yipeng Exp $
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("encoder",new MyLongToByteEncoder());
        //pipeline.addLast("decoder",new MyByteToLongDecoder());
        pipeline.addLast("decoder",new MyByteToLongDecoder2());
        pipeline.addLast(new MyClientHandler());
    }
}
