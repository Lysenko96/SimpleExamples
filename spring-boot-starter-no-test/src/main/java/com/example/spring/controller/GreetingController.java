package com.example.spring.controller;

import com.example.spring.service.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RequestMapping("/spring-web")
@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final CompanyService companyService;

    @GetMapping(value = "/hello/{id}")
    public ModelAndView hello(ModelAndView mv, HttpServletRequest request,
                              @RequestParam(value = "age", required = false) Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable(value = "id", required = false) Integer id) {

        System.out.println(companyService);
        mv.setViewName("/greeting/hello");
        return mv;
    }

    @GetMapping(value = "/bye")
    public ModelAndView bye(ModelAndView mv) {
        mv.setViewName("/greeting/bye");
        return mv;
    }
}
