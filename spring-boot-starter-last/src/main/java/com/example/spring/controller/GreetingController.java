package com.example.spring.controller;

import com.example.spring.dto.UserReadDto;
import com.example.spring.model.Role;
import com.example.spring.service.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/spring-web")
@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class GreetingController {

    private final CompanyService companyService;

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return new ArrayList<>(Arrays.asList(Role.values()));
    }

    @GetMapping(value = "/hello/{id}")
    public String hello(Model mv, HttpServletRequest request,
                        @RequestParam(value = "age", required = false) Integer age,
                        @RequestHeader(value = "accept", required = false) String accept,
                        @CookieValue(value = "JSESSIONID", required = false) String jsessionId,
                        @PathVariable(value = "id", required = false) Integer id,
                        UserReadDto userReadDto) {

        System.out.println(companyService);
        mv.addAttribute("user", userReadDto);
        return "/greeting/hello";
    }

    @GetMapping(value = "/bye")
    public String bye(ModelAndView mv, @SessionAttribute(value = "user", required = false) UserReadDto userReadDto) {
        return "/greeting/bye";
    }
}
