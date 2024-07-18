package org.example.loadonstartup.servlet;

import jakarta.servlet.http.HttpServlet;

public class ServletOne extends HttpServlet {

    @Override
    public void init() {
        System.out.println(this.getClass().getName() + " init.");
    }
}
