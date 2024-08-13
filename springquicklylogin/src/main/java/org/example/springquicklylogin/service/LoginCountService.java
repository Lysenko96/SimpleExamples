package org.example.springquicklylogin.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Getter
public class LoginCountService {

    private int count;

    public void increment() {
        count++;
    }
}
