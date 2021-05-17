package com.rainlin.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @author rainlin
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("添加了Servlet:" + srae.getServletRequest() + "请求属性" + "[" + srae.getName() + ":" + srae.getValue() + "]");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("移除了Servlet:" + srae.getServletRequest() + "请求属性" + "[" + srae.getName() + ":" + srae.getValue() + "]");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("更新了Servlet:" + srae.getServletRequest() + "请求属性" + "[" + srae.getName() + ":" + srae.getValue() + "]");
    }
}
