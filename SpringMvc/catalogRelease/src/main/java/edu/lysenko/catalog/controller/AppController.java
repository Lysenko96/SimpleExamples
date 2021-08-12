package edu.lysenko.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;
	@Autowired
	private JdbcUserDao userDao;

	@GetMapping(value = "/registerate")
	public String menuRegisterate() {
		return "registerate";
	}

	@GetMapping(value = "/login")
	public String menuLogin() {
		return "login";
	}

	@PostMapping(value = "/registerate")
	public String registerate(Model model, @ModelAttribute("user") User user) {
		return userService.save(user);
	}

	@PostMapping(value = "/update")
	public String update(Model model, @ModelAttribute("user") User user) {
		return userService.update(user);
	}

	@GetMapping(value = "/edit")
	public ModelAndView editUser(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = userDao.getById(id);
		System.out.println(user);
		ModelAndView model = new ModelAndView("edit");
		model.addObject("user", user);
		return model;
	}

	@PostMapping(value = "/login")
	public String login(Model model, @ModelAttribute("user") User user) {
		return userService.authorize(user);
	}

	@GetMapping("/admin")
	public ModelAndView listUser(ModelAndView model) {
		List<User> listUser = userDao.getAll();
		model.addObject("listUser", listUser);
		model.setViewName("admin");
		return model;
	}

}