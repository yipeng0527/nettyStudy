package com.yp.netty.rpc.provider;

import com.yp.netty.rpc.api.IRpcHelloService;

/**
 * @author ex-yipeng
 * @version Id: RpcHelloServiceImpl.java, v 0.1 2020/6/24 13:50 ex-yipeng Exp $
 */
public class RpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
