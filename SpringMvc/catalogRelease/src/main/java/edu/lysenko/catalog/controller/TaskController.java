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
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private JdbcTaskDao taskDao;
	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/task")
	public String menuTask() {
		return "task";
	}

	@PostMapping(value = "/task")
	public String addTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.save(task);
	}

	@GetMapping(value = "/deleteTask")
	public String deleteTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.delete(task);
	}

	@PostMapping(value = "/updateTask")
	public String updateTask(Model model, @ModelAttribute("task") Task task) {
		return taskService.update(task);
	}

	@GetMapping(value = "/editTask")
	public ModelAndView editTask(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Task task = taskDao.getById(id);
		ModelAndView model = new ModelAndView("editTask");
		model.addObject("task", task);
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
