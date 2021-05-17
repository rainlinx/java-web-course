package com.rainlin.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * TokenFilter
 *
 * @author rainlin
 */
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName() + "初始化成功");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req= (HttpServletRequest) request;
        req.getSession(true).setAttribute("sessionId", req.getSession().getId());
        System.out.println("拦截到请求" + "[" + req.getMethod() + ":" + req.getRequestURI() + "]");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("tokenFilter销毁成功");
    }
}
