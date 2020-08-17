package com.yp.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * Created by pp on 2020/8/17.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    /**
     * 上下文
     */
    private ChannelHandlerContext cx;

    /**
     * 返回的结果
     */
    private String result;

    /**
     * 客户端调用方法时，传入的参数
     */
    private String para;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channelActive 被调用  ");
        cx = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channelRead 被调用  ");
        result = msg.toString();
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println(" call1 被调用  ");
        cx.writeAndFlush(para);
        wait();   //等待channelRead 方法获取到服务器的结果后，唤醒
        System.out.println(" call2 被调用  ");
        return result;
    }

    void setPara(String para) {
        this.para = para;
    }
}
