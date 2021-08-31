package edu.lysenko.catalog.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	private JdbcUserDao userDao;
	private static int id;

	public UserService(JdbcUserDao userDao) {
		this.userDao = userDao;
	}

	public String add(User user) {
		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPassword());
		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
			userDao.add(user);
		}
		if (user.getRole() == null || user.getPassword().isEmpty() || user.getName().isEmpty()
				|| user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().name().isEmpty()) {
			return "redirect:/register";
		}
		return "redirect:/login";
	}

	public String update(User user) {
		User userDb = userDao.findUserByEmail(user.getEmail());
		if (user.getRole() != null && !user.getPassword().isEmpty() && !user.getEmail().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
			userDao.update(user);
		} else {
			return "redirect:/edit?id=" + userDb.getId();
		}
		return "redirect:/admin";
	}

	public String delete(User user) {
		if (userDao.getById(UserService.getId()).getRole().equals(Role.ADMIN)) {
			User userDb = userDao.getById(user.getId());
			userDao.deleteById(userDb.getId());
		}
		return "redirect:/admin";
	}

	public String authorize(User user) {
		User userDb = userDao.findUserByEmail(user.getEmail());
		userDb.setLastLogin(LocalTime.now());
		userDao.update(userDb);
		return "redirect:/admin";
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		UserService.id = id;
	}
}