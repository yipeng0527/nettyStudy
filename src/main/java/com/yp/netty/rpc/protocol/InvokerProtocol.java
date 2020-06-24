package com.yp.netty.rpc.protocol;

import java.io.Serializable;

/**
 * @author ex-yipeng
 * @version Id: InvokerProtocol.java, v 0.1 2020/6/24 13:54 ex-yipeng Exp $
 */
public class InvokerProtocol implements Serializable {

    private String className; //类名
    private String methodName; //函数名称
    private Class<?> [] parames; //形参列表
    private Object[] values; //实参列表

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParames() {
        return parames;
    }

    public void setParames(Class<?>[] parames) {
        this.parames = parames;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
