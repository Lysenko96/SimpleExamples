package com.example.jndi;

import com.zaxxer.hikari.HikariDataSource;

import java.io.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class HelloServlet extends HttpServlet {

    private String DATASOURCE_JNDI_NAME = "java:/comp/env/jdbc/postgres";

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Context context = null;
        try {
            context = new InitialContext();
            DataSource source = (DataSource) context.lookup(DATASOURCE_JNDI_NAME);
            response.getWriter().println(source);
        } catch (NamingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}