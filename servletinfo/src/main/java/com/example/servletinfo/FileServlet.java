package com.example.servletinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(name = "fileServlet", value = "/fileServlet/*")
// config binary file
@MultipartConfig(location = "/home/user/Documents/Spd/servletinfo/")
public class FileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String author = req.getParameter("author");
        if (author.equals("author")) {
            req.getParts().stream()
                    .filter(p -> p.getName().equals("file"))
                    .map(part -> {
                        String text;
                        try {
                            InputStream inputStream = part.getInputStream();
                            InputStreamReader reader = new InputStreamReader(inputStream);
                            text = new BufferedReader(reader)
                                    .lines()
                                    .collect(Collectors.joining(System.lineSeparator()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        out.println(text);
                        return text;
                    }).forEach(System.out::println);
        } else {
            req.getParts().stream()
                    .filter(p -> p.getName().equals("file"))
                    .map(p -> {
                        String path;
                        try {
                            path = UUID.randomUUID() + p.getSubmittedFileName();
                            p.write(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        out.println(path);
                        return path;
                    }).forEach(System.out::println);
        }
    }
}
