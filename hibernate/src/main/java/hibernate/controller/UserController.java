package hibernate.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hibernate.dao.impl.UserDaoImpl;
import hibernate.entity.User;
import hibernate.service.UserService;

@Component
public class UserController {

	private UserDaoImpl userDao;
	private UserService userService;

	public UserController(UserDaoImpl userDao, UserService userService) {
		this.userDao = userDao;
		this.userService = userService;
	}

	@GetMapping(value = "/register")
	public String menuRegister() {
		return "register";
	}

	@GetMapping(value = "/login")
	public String menuLogin() {
		return "login";
	}

//	@PostMapping(value = "/register")
//	public String register(Model model, @ModelAttribute("user") User user) {
//		return userService.save(user);
//	}
}
