package com.yp.netty.dubborpc.publicinterface;

/**
 * Created by pp on 2020/8/17.
 */
public interface IHelloService {

    /**
     * 这个是公共接口提供给服务方和消费方
     * @param msg
     * @return
     */
    String sayHello(String msg);
}
