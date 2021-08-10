package edu.lysenko.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registerate", method = RequestMethod.GET)
	public String menuRegisterate() {
		return "registerate";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String menuLogin() {
		return "login";
	}

	@RequestMapping(value = "/registerate", method = RequestMethod.POST)
	public String registerate(Model model, @ModelAttribute("user") User user) {
		return userService.getRegisterateMapping(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("user") User user) {
		return userService.getLoginMapping(user);
	}
}