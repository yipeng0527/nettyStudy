package com.yp.netty.rpc.consumer;

import com.yp.netty.rpc.api.IRpcHelloService;
import com.yp.netty.rpc.api.IRpcService;
import com.yp.netty.rpc.consumer.proxy.RpcProxy;

/**
 * @author ex-yipeng
 * @version Id: RpcConsumer.java, v 0.1 2020/6/24 13:56 ex-yipeng Exp $
 */
public class RpcConsumer {

    public static void main(String[] args) {
        IRpcHelloService rpcHello = RpcProxy.create(IRpcHelloService.class);

        System.out.println(rpcHello.hello("Tom老师"));

        IRpcService service = RpcProxy.create(IRpcService.class);

        System.out.println("8 + 2 = " + service.add(8, 2));
        System.out.println("8 - 2 = " + service.sub(8, 2));
        System.out.println("8 * 2 = " + service.mult(8, 2));
        System.out.println("8 / 2 = " + service.div(8, 2));
    }


}
