package com.example.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.model.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String checkValid(Model model, @ModelAttribute("user") User user) {
		if (user.getName().equals("Admin") && user.getPasswd().equals("123")) {
			return "success";
		} else {
			return "login";
		}
	}
}