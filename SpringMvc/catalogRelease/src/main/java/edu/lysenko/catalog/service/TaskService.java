package edu.lysenko.catalog.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
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
		try {
			if (UserService.getId() == userId) {
				if (!task.getTag().isEmpty() && !task.getTitle().isEmpty()
						&& taskDao.findTaskByName(task.getTag()) == null) {
					taskDao.add(task);
					Task taskDb = taskDao.findTaskByName(task.getTag());
					taskDao.add(UserService.getId(), taskDb.getId());
				}
			}
			return "redirect:/user?id=" + UserService.getId();
		} catch (DuplicateKeyException e) {
			return "redirect:/task";
		}
	}

	public String update(Task task, int userId) {
		Task taskDb = taskDao.findTaskByName(task.getTag());
		if (UserService.getId() == userId) {
			if (!task.getTag().isEmpty() && !task.getTitle().isEmpty() && taskDb != null) {
				taskDao.update(task);
			} else if (task.getTag().isEmpty() || task.getTitle().isEmpty()) {
				return "redirect:/editTask?id=" + task.getId();
			}
		}
		return "redirect:/user?id=" + UserService.getId();
	}

	public String delete(Task task, int userId) {
		if (UserService.getId() == userId) {
			Task taskDb = taskDao.getById(task.getId());
			taskDao.deleteFromUsersTasksByTaskId(task.getId());
			taskDao.deleteById(taskDb.getId());
		}
		return "redirect:/user?id=" + userId;
	}

	public List<Task> search(String keyword) {
		return taskDao.searchAllByTag(keyword);
	}
}
