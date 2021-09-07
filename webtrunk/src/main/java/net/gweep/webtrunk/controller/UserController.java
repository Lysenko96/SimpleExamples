package net.gweep.webtrunk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.gweep.webtrunk.entity.User;
import net.gweep.webtrunk.repo.UserRepo;

@Controller
public class UserController {

	private UserRepo userRepo;

	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@PostMapping("/save")
	public @ResponseBody String save(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepo.save(user);
		return "Saved";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAll() {
		return userRepo.findAll();
	}
}
