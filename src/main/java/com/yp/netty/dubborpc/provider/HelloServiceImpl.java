package com.yp.netty.dubborpc.provider;

import com.yp.netty.dubborpc.publicinterface.IHelloService;

/**
 * Created by pp on 2020/8/17.
 */
public class HelloServiceImpl implements IHelloService {

    private static int count = 0;

    @Override
    public String sayHello(String msg) {
        if (null != msg) {
            return "你好客户端, 我已经收到你的消息 [" + msg + "] 第" + (++count) + " 次";
        } else {
            return "你好客户端, 我已经收到你的消息 ";
        }
    }
}
