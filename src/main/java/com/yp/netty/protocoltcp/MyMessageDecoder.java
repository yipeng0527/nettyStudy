package com.yp.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author ex-yipeng
 * @version Id: MyMessageDecoder.java, v 0.1 2020/8/7 15:49 ex-yipeng Exp $
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode 被调用");
        MessageProtocol message = new MessageProtocol();

        int len = in.readInt();
        byte[] buffer = new byte[len];
        in.readBytes(buffer);

        message.setLength(len);
        message.setContent(buffer);

        out.add(message);
    }
}
