package com.yp.netty.dubborpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pp on 2020/8/17.
 */
public class NettyClient {

    private static ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private int count = 0;

    private static NettyClientHandler clientHandler;

    public Object getBean(final Class<?> serivceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{serivceClass},
                (proxy, method, args) -> {
                    if (null == clientHandler) {
                        initClient();
                    }
                    clientHandler.setPara(providerName + args[0]);
                    return executor.submit(clientHandler).get();
                });
    }

    private static void initClient() {
        clientHandler = new NettyClientHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        client.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(clientHandler);
                    }
                });
        try {
            client.connect("127.0.0.1", 8888).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
