package com.example.javabasic.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/startup")
public class StartupServlet extends HttpServlet {

    private List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        if(name != null) session.setAttribute("name", name);
        name = (String) session.getAttribute("name");
        resp.getWriter().print("Hello ");
        resp.getWriter().print(name != null ? name : "my friend!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.lines().collect(Collectors.joining());
        ObjectMapper objectMapper = new ObjectMapper();
        Message message = objectMapper.readValue(json, Message.class);
        messages.add(message);
        resp.getWriter().println(messages);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Message{
        private String name;
        private String message;
    }


}
