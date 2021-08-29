package edu.lysenko.catalog.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import edu.lysenko.catalog.config.WebConfig;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	WebApplicationContext context;

	private JdbcUserDao userDao;
	private static int id;
	private static Logger log = Logger.getLogger(UserService.class.getName());

	public UserService(JdbcUserDao userDao, WebApplicationContext context) {
		this.context = context;
		this.context.getBean(WebConfig.class).createSchema();
		this.userDao = userDao;
	}

	public String add(User user) {
		log.info(user.toString());
		userDao.save(user);
//		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPassword());
//		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()
//				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
//			userDao.save(user);
//		}
//		if (user.getRole() == null || user.getPassword().isEmpty() || user.getName().isEmpty()
//				|| user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().isEmpty()) {
//			return "redirect:/register";
//		}
		return "redirect:/login";
	}

	public String update(User user) {
//		User userDb = userDao.findUserByEmail(user.getEmail());
//		if (user.getRole() != null && !user.getPassword().isEmpty() && !user.getEmail().isEmpty()
//				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
		userDao.update(user);
//		} else {
//			return "redirect:/edit?id=" + userDb.getId();
//		}
		return "redirect:/admin";
	}

	public String delete(User user) {
		// if (userDao.getById(UserService.getId()).getRole().equals(Role.ADMIN)) {
		User userDb = userDao.getById(user.getId());
		// find all id task by user id
		List<Task> tasks = userDb.getTasks();
		// in loop delete each task, delete user
		for (Task task : tasks) {
			userDao.deleteFromUsersTasksByUserId(userDb.getId(), task.getId());
		}
		userDao.deleteById(userDb.getId());
		// }
		return "redirect:/admin";
	}

	public String authorize(User user) {
		// if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
		User userDb = userDao.findUserByEmail(user.getEmail());
		System.out.println(userDb);

//			if (userDb != null) {
//				id = userDb.getId();
//			}
//		if (userDb.getRole().equals(Role.USER.name())) {
//			return "redirect:/user?id=" + userDb.getId();
//		} else if (userDb.getRole().equals(Role.ADMIN.name())) {
//			return "redirect:/admin";
//		}
		// }
		return "redirect:/admin";
		// return "redirect:/login";

	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		UserService.id = id;
	}
}