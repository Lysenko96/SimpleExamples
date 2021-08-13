package edu.lysenko.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.entity.Task;

@Service
public class TaskService {

	@Autowired
	private JdbcTaskDao taskDao;

	private Logger log = Logger.getLogger(TaskService.class.getName());

	public String save(Task task) {
		List<String> names = new ArrayList<>();
		if (!taskDao.getAll().isEmpty()) {
			for (Task entity : taskDao.getAll()) {
				names.add(entity.getName());
			}
		}
		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && !names.contains(task.getName())) {
			taskDao.add(task);
		}
		log.info(task.toString());
		Task taskDb = taskDao.findTaskByName(task.getName());
		log.info(taskDb.toString());
		String mapping = "redirect:/user";
		if (taskDb == null || names.contains(task.getName())) {
			mapping = "redirect:/task";
		}
		return mapping;
	}

	public String update(Task task) {
		List<String> names = new ArrayList<>();
		if (!taskDao.getAll().isEmpty()) {
			for (Task entity : taskDao.getAll()) {
				names.add(entity.getName());
			}
		}
		String mapping = "redirect:/user";

		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && !names.contains(task.getName())) {
			taskDao.update(task);
		} else if (task.getName().isEmpty() || task.getTitle().isEmpty()) {
			mapping = "redirect:/editTask?id=" + task.getId();
		}
		log.info(task.toString());
		Task taskDb = taskDao.findTaskByName(task.getName());
		if (taskDb == null || names.contains(task.getName())) {
			mapping = "redirect:/editTask?id=" + task.getId();
		}
		return mapping;
	}

	public String delete(Task task) {
		Task taskDb = taskDao.getById(task.getId());
		System.out.println(taskDb);
		taskDao.deleteById(taskDb.getId());
		return "redirect:/user";
	}

}
