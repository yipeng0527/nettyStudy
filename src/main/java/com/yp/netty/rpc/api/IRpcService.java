package com.yp.netty.rpc.api;

/**
 * @author ex-yipeng
 * @version Id: IRpcService.java, v 0.1 2020/6/24 13:48 ex-yipeng Exp $
 */
public interface IRpcService {

    /** 加 */
    public int add(int a,int b);

    /** 减 */
    public int sub(int a,int b);

    /** 乘 */
    public int mult(int a,int b);

    /** 除 */
    public int div(int a,int b);
}
