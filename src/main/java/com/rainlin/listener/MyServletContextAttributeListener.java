package com.rainlin.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 监听ServletContext
 * @author rainlin
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("添加了Servlet请求属性" + "[" + scae.getName() + ":" + scae.getValue() + "]");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("移除了Servlet请求属性" + "[" + scae.getName() + ":" + scae.getValue() + "]");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("更新了Servlet请求属性" + "[" + scae.getName() + ":" + scae.getValue() + "]");
    }
}
