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
	private JdbcTaskDao taskDao;
	private static int id;

	public UserService(JdbcUserDao userDao, JdbcTaskDao taskDao, WebApplicationContext context) {
		this.context = context;
		this.context.getBean(WebConfig.class).createSchema();
		this.userDao = userDao;
		this.taskDao = taskDao;
	}

	public String add(User user) {
		userDao.save(user);
		return "redirect:/login";
	}

	public String update(User user) {
		userDao.update(user);
		return "redirect:/admin";
	}

	// check del
	
	public String delete(User user) {
		User userDb = userDao.findUserByEmail(user.getEmail());
		for (Integer index : taskDao.getAllTaskIdsByUserId(userDb.getId())) {
			userDb.getTasks().remove(index);
		}
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