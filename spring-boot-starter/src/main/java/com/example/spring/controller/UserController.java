package com.example.spring.controller;

import com.example.spring.dto.UserCreateEditDto;
import com.example.spring.dto.UserReadDto;
import com.example.spring.model.Role;
import com.example.spring.service.CompanyService;
import com.example.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAll(Model model) {
        List<UserReadDto> users = userService.findAll();
        model.addAttribute("users", users);
        System.out.println("findAll");
        System.out.println(users);
        return "/user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        System.out.println("findById");
        return userService.findById(id).map(userReadDto -> {
            model.addAttribute("user", userReadDto);
            model.addAttribute("roles", Role.values());
            model.addAttribute("companies", companyService.findAll());
            return "/user/user";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(@RequestBody UserCreateEditDto createDto, RedirectAttributes redirectAttributes) {
        if (true) {
            redirectAttributes.addFlashAttribute("user", createDto);
            return "redirect:/users/registration";
        }
        UserReadDto userReadDto = userService.create(createDto);
        System.out.println("create");
        System.out.println(userReadDto);
        return "redirect:/users/" + userReadDto.getId();
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto createDto) {
        System.out.println("update");
        return userService.update(id, createDto)
                .map(user -> "redirect:/users/" + user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        boolean delete = userService.delete(id);
        System.out.println("delete");
        if (!delete) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }


}
