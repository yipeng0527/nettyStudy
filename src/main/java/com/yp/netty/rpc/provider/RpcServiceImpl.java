package com.yp.netty.rpc.provider;

import com.yp.netty.rpc.api.IRpcHelloService;
import com.yp.netty.rpc.api.IRpcService;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * @author ex-yipeng
 * @version Id: RpcServiceImpl.java, v 0.1 2020/6/24 13:50 ex-yipeng Exp $
 */
public class RpcServiceImpl implements IRpcService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
