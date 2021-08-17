package edu.lysenko.catalog.service;

import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.entity.Task;

@Service
public class TaskService {

	private JdbcTaskDao jdbcTaskDao;

	public TaskService(JdbcTaskDao jdbcTaskDao) {
		this.jdbcTaskDao = jdbcTaskDao;
	}

	public String add(Task task) {
		Task taskDb = jdbcTaskDao.findTaskByName(task.getName());
		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb == null) {
			jdbcTaskDao.add(task);
		} else if (taskDb != null) {
			return "redirect:/task";
		}
		return "redirect:/user";
	}

	public String update(Task task) {
		Task taskDb = jdbcTaskDao.findTaskByName(task.getName());
		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb == null) {
			jdbcTaskDao.update(task);
		} else if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb != null) {
			return "redirect:/editTask?id=" + task.getId();
		}
		return "redirect:/user";
	}

	public String delete(Task task) {
		Task taskDb = jdbcTaskDao.getById(task.getId());
		jdbcTaskDao.deleteById(taskDb.getId());
		return "redirect:/user";
	}
}
