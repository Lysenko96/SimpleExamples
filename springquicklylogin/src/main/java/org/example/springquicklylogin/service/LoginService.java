package org.example.springquicklylogin.service;

import org.example.springquicklylogin.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestScope
public class LoginService {

    @Value("${spring.username}")
    private String username;
    @Value("${spring.password}")
    private String password;

    public String validateUser(User user) {
        String message = "Login failed";
        if (user != null && user.getUsername() != null
                && user.getUsername().equals(username) && user.getPassword() != null
                && user.getPassword().equals(password)) message = "Login successful";
        return message;
    }
}
