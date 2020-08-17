package com.yp.netty.dubborpc.customer;

import com.yp.netty.dubborpc.netty.NettyClient;
import com.yp.netty.dubborpc.publicinterface.IHelloService;

/**
 * Created by pp on 2020/8/17.
 */
public class ClientBootstrap {

    public static String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();

        IHelloService helloService = (IHelloService) nettyClient.getBean(IHelloService.class, providerName);

        String result = helloService.sayHello("服务器你好 我是dubbo");
        System.out.println(result);
    }
}
