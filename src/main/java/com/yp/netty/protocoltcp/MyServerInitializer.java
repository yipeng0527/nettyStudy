package com.yp.netty.protocoltcp;

        import io.netty.channel.ChannelInitializer;
        import io.netty.channel.ChannelPipeline;
        import io.netty.channel.socket.SocketChannel;

/**
 * @author ex-yipeng
 * @version Id: MyServerInitializer.java, v 0.1 2020/8/7 13:47 ex-yipeng Exp $
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decoder", new MyMessageDecoder());
        pipeline.addLast("encoder", new MyMessageEncoder());
        pipeline.addLast(new MyServerHandler());
    }
}
