package com.example.servletinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "helloServlet", value = "/helloServlet/*")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    //http://localhost:8080/servletinfo/helloServlet/more/1?one=1,2,3&text=text&one=some
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        String uri = request.getRequestURI();
        out.println("<html><body>");
        out.write(uri);
        Map<String, String[]> params = request.getParameterMap();

        params.forEach((key, value) -> out.println("<br>" + key + " " + Arrays.toString(value)));

        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.write(uri);
        Map<String, String[]> params = request.getParameterMap();

        params.forEach((key, value) -> out.println("<br>" + key + " " + Arrays.toString(value)));
    }

    public void destroy() {
        System.out.println("destroy");
    }
}