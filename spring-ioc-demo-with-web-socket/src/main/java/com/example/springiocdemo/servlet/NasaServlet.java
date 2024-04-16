package com.example.springiocdemo.servlet;

import com.example.springiocdemo.config.Config;
import com.example.springiocdemo.model.Client;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/nasa") // class NasaServlet work without @EnableWebMvc
public class NasaServlet extends HttpServlet {

    private static final String ROOT_CONTEXT = "ROOT_CONTEXT";
    private AnnotationConfigApplicationContext springContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(Config.class);
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute(ROOT_CONTEXT, springContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = new PrintWriter(resp.getWriter());
        springContext = (AnnotationConfigApplicationContext) req.getServletContext().getAttribute(ROOT_CONTEXT);
        Client client1 = springContext.getBean(Client.class);
        client1.getStrings().forEach(writer::println);
        Enumeration<String> it = req.getServletContext().getAttributeNames();
        while (it.hasMoreElements()) {
            try {
                resp.getWriter().println(it.nextElement());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void destroy() {
        springContext.close();
    }
}
