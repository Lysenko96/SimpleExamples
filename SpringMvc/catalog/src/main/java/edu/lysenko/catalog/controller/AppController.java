package edu.lysenko.catalog.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@Controller
public class AppController {

	Logger log = Logger.getLogger(AppController.class.getName());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkValid(Model model, @ModelAttribute("user") User user) {
		log.info(user.toString());
		if (user.getRole().equals(Role.USER)) {
			return "user";
		} else if (user.getRole().equals(Role.ADMIN)) {
			return "admin";
		} else {
			return "login";
		}
	}
}