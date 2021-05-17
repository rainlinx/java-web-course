package com.rainlin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author rainlin
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1123220962121953235L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");

        if (Objects.equals(userName, "admin") && Objects.equals(password, "admin")) {
            response.getWriter().println("login success");
        }
    }
}
