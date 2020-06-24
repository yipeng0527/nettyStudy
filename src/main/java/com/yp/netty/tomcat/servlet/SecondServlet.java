package com.yp.netty.tomcat.servlet;

import com.yp.netty.tomcat.http.MyRequest;
import com.yp.netty.tomcat.http.MyResponse;
import com.yp.netty.tomcat.http.MyServlet;

/**
 * @author ex-yipeng
 * @version Id: SecondServlet.java, v 0.1 2020/6/24 10:50 ex-yipeng Exp $
 */
public class SecondServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        doPost(request, response);
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("This is Second Serlvet");
    }
}
