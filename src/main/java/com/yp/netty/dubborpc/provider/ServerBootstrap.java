package com.yp.netty.dubborpc.provider;

import com.yp.netty.dubborpc.netty.NettyServer;

/**
 * Created by pp on 2020/8/17.
 */
public class ServerBootstrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 8888);
    }
}
