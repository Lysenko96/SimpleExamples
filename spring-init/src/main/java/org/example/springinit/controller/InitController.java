package org.example.springinit.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.springinit.model.User;
import org.example.springinit.model.UserHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(value = "/init")
public class InitController {

    private Map<String, User> userMap = new ConcurrentHashMap<>();
    private HttpServletRequest request;
    private HttpServletResponse response;
    private UserHolder userHolder;

    private HttpSession session;
    private String sessionId;

    public InitController(HttpServletRequest request, HttpServletResponse response, UserHolder userHolder, HttpSession session) {
        this.request = request;
        this.response = response;
        this.userHolder = userHolder;
        this.session = session;
    }

    @PostMapping
    public void init(@RequestBody User user) {
        try {
            PrintWriter writer = response.getWriter();
//            BufferedReader reader = request.getReader();
//            String userJson = reader.lines().collect(Collectors.joining());
//            ObjectMapper objectMapper = new ObjectMapper();
//            User user = objectMapper.readValue(userJson, User.class);
            userMap.putIfAbsent(request.getRemoteAddr(), user);

            if (userHolder.getCurrent() == null) {
                userHolder.setCurrent(user);
            }

            writer.println(userMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public Map<String, User> getAllUsers() {
        return userMap;
//        try {
//            PrintWriter writer = response.getWriter();
//            userMap.entrySet().forEach(System.out::println);
//            writer.flush();
//            writer.println(userMap);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        response.addCookie(new Cookie("JSESSIONID", sessionId));
        return userHolder.getCurrent();
    }

    // 1. post
    // 2. /session
    // 3. check browser /current (use one session in browser and in rest-api test idea
    @GetMapping("/session")
    public String setSessionId(@CookieValue("JSESSIONID") String sessionId){
        this.sessionId = sessionId;
        return sessionId;
    }
}
