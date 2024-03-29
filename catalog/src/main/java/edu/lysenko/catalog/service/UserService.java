package edu.lysenko.catalog.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import edu.lysenko.catalog.config.WebConfig;
import edu.lysenko.catalog.dao.jdbc.JdbcTaskDao;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	WebApplicationContext context;

	private JdbcUserDao userDao;
	TaskService taskService;
	private static int id;
	
	//task service for delete from many to many

	public UserService(JdbcUserDao userDao, WebApplicationContext context, TaskService taskService) {
		this.context = context;
		this.context.getBean(WebConfig.class).createSchema();
		this.userDao = userDao;
		this.taskService = taskService;
	}

	public String add(User user) {
		userDao.save(user);
		return "redirect:/login";
	}

	public String update(User user) {
		userDao.update(user);
		return "redirect:/admin";
	}

	//-------------------------- here
	
	public String delete(User user) {
		User userDb = userDao.getById(user.getId());
		System.out.println("serv " + userDb.getTasks());
		System.out.println(userDb.getTasks().get(0));
		taskService.delete(userDb.getTasks().get(0), user.getId());
		userDao.deleteById(userDb.getId());
		return "redirect:/admin";
	}

	public String authorize(User user) {
		return "redirect:/admin";
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		UserService.id = id;
	}
}