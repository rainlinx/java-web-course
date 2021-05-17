package com.rainlin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 设置请求、响应字符编码格式
 *
 * @author rainlin
 */
@WebFilter(filterName = "characterFilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName() + "初始化成功");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("tokenFilter销毁成功");
    }
}
