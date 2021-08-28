package hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

	@GetMapping(value = "/register")
	public String menuRegister() {
		return "register";
	}

	@GetMapping(value = "/login")
	public String menuLogin() {
		return "login";
	}
}
