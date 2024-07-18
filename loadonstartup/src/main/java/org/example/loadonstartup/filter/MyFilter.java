package org.example.loadonstartup.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

//@WebServlet("helloServlet")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter.doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init " + this.getClass().getSimpleName());
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        System.out.println("destroy " + this.getClass().getSimpleName());
        Filter.super.destroy();
    }
}
