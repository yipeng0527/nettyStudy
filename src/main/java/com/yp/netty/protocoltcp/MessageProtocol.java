package com.yp.netty.protocoltcp;

/**
 * @author ex-yipeng
 * @version Id: MessageProtocol.java, v 0.1 2020/8/7 15:43 ex-yipeng Exp $
 */
public class MessageProtocol {

    /**
     * 消息长度
     */
    private int length;

    /**
     * 消息内容
     */
    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
