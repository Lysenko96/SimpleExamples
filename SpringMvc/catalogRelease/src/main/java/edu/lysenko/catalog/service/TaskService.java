package edu.lysenko.catalog.service;

import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.entity.Task;

@Service
public class TaskService {

	private JdbcTaskDao taskDao;

	public TaskService(JdbcTaskDao jdbcTaskDao) {
		this.taskDao = jdbcTaskDao;
	}

	public String add(Task task, int userId) {
		Task taskDb = taskDao.findTaskByName(task.getName());
		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb == null) {
			taskDao.add(task);
			taskDb = taskDao.findTaskByName(task.getName());
			if (taskDb != null) {
				taskDao.add(userId, taskDb.getId());
			} else {
				return "redirect:/task";
			}
		} else if (taskDb != null) {
			taskDao.add(userId, taskDb.getId());
			return "redirect:/user?id=" + userId;
		}
		return "redirect:/user?id=" + userId;
	}

	public String update(Task task, int userId) {
		Task taskDb = taskDao.findTaskByName(task.getName());
		if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb == null) {
			taskDao.update(task);
		} else if (!task.getName().isEmpty() && !task.getTitle().isEmpty() && taskDb != null) {
			return "redirect:/editTask?id=" + task.getId();
		}
		return "redirect:/user";
	}

	public String delete(Task task, int userId) {
		Task taskDb = taskDao.getById(task.getId());
		taskDao.deleteById(taskDb.getId());
		return "redirect:/user?id=" + userId;
	}
}
