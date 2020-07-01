package com.yp.netty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author ex-yipeng
 * @version Id: NIOClient.java, v 0.1 2020/7/1 10:02 ex-yipeng Exp $
 */
public class NIOClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);

        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为链接需要时间客户端不会阻塞 可以去做其他事情");
            }
        }

        String info = "你好 我是乐多 你养我啊";

        socketChannel.write(ByteBuffer.wrap(info.getBytes("UTF-8")));

        System.out.println("客户端发起消息:" + info);
        System.in.read();
    }
}
