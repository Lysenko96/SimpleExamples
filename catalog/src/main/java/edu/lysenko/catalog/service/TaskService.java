package edu.lysenko.catalog.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;

@Service
public class TaskService {

	JdbcTaskDao taskDao;
	JdbcUserDao userDao;

	public TaskService(JdbcTaskDao taskDao, JdbcUserDao userDao) {
		this.taskDao = taskDao;
		this.userDao = userDao;
	}

	public String add(Task task, int userId) {
		taskDao.save(task);
		task.setUsers(Arrays.asList(userDao.getById(userId)));
		taskDao.update(task);
		return "redirect:/admin";
	}

	public String update(Task task, int userId) {
		taskDao.update(task);
		task.setUsers(Arrays.asList(userDao.getById(userId)));
		taskDao.update(task);
		return "redirect:/admin";

	}

	public String delete(Task task, int userId) {
		Task taskDb = taskDao.getById(task.getId());
		taskDao.deleteFromUsersTasksByTaskId(task.getId(), userId);
		taskDao.deleteById(taskDb.getId());
		return "redirect:/admin";
	}

	public List<Task> search(String keyword, int userId) {
		return taskDao.searchAllByTag(keyword);
	}
}
