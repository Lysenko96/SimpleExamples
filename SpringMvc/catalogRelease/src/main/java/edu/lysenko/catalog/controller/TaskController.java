package edu.lysenko.catalog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.service.TaskService;

@Controller
public class TaskController {

	private JdbcTaskDao taskDao;
	private TaskService taskService;

	public TaskController(JdbcTaskDao taskDao, TaskService taskService) {
		this.taskDao = taskDao;
		this.taskService = taskService;
	}

	@GetMapping(value = "/task")
	public String menu() {
		return "task";
	}

	@GetMapping(value = "/editTask")
	public ModelAndView edit(@RequestParam("id") int id) {
		Task task = taskDao.getById(id);
		ModelAndView model = new ModelAndView("editTask");
		model.addObject("task", task);
		return model;
	}

	@GetMapping("/user")
	public ModelAndView list(ModelAndView model) {
		List<Task> listTask = taskDao.getAll();
		model.addObject("listTask", listTask);
		model.setViewName("user");
		return model;
	}

	@GetMapping(value = "/deleteTask")
	public String delete(Model model, @ModelAttribute("task") Task task) {
		return taskService.delete(task);
	}

	@PostMapping(value = "/task")
	public String add(Model model, @ModelAttribute("task") Task task) {
		return taskService.add(task);
	}

	@PostMapping(value = "/updateTask")
	public String update(Model model, @ModelAttribute("task") Task task) {
		return taskService.update(task);
	}
}
