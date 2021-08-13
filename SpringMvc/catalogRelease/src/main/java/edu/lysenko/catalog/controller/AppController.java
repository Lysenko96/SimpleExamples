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

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.service.TaskService;
import edu.lysenko.catalog.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private JdbcUserDao userDao;
	@Autowired
	private JdbcTaskDao taskDao;

	@GetMapping(value = "/registerate")
	public String menuRegisterate() {
		return "registerate";
	}

	@GetMapping(value = "/task")
	public String menuTask() {
		return "task";
	}

	@GetMapping(value = "/login")
	public String menuLogin() {
		return "login";
	}

	@PostMapping(value = "/registerate")
	public String registerate(Model model, @ModelAttribute("user") User user) {
		return userService.save(user);
	}

	@PostMapping(value = "/task")
	public String addTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.save(task);
	}

	@PostMapping(value = "/update")
	public String update(Model model, @ModelAttribute("user") User user) {
		return userService.update(user);
	}

	@GetMapping(value = "/deleteTask")
	public String deleteTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.delete(task);
	}

	@PostMapping(value = "/updateTask")
	public String updateTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.update(task);
	}

	@GetMapping(value = "/delete")
	public String delete(Model model, @ModelAttribute("user") User user) {
		return userService.delete(user);
	}

	@GetMapping(value = "/edit")
	public ModelAndView editUser(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = userDao.getById(id);
		user.setPasswd("");
		ModelAndView model = new ModelAndView("edit");
		model.addObject("user", user);
		return model;
	}

	@GetMapping(value = "/editTask")
	public ModelAndView editTask(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Task task = taskDao.getById(id);
		ModelAndView model = new ModelAndView("editTask");
		model.addObject("task", task);
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

	@GetMapping("/user")
	public ModelAndView listTask(ModelAndView model) {
		List<Task> listTask = taskDao.getAll();
		model.addObject("listTask", listTask);
		model.setViewName("user");
		return model;
	}

}