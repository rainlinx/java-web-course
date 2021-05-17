package com.rainlin.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author rainlin
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求:" + ((HttpServletRequest) sre.getServletRequest()).getRequestURI() + "已销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求:" + ((HttpServletRequest) sre.getServletRequest()).getRequestURI() + "已初始化");
    }
}
