package edu.lysenko.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	@Autowired
	private JdbcUserDao jdbcUserDao;

	public String add(User user) {
		User userDb = jdbcUserDao.findUserByEmailPass(user.getEmail(), user.getPasswd());
		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPasswd().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
			jdbcUserDao.add(user);
		}
		if (user.getRole() == null || user.getPasswd().isEmpty() || user.getName().isEmpty()
				|| user.getSurname().isEmpty() || user.getEmail().isEmpty() || user.getRole().name().isEmpty()) {
			return "redirect:/register";
		}
		return "redirect:/login";
	}

	public String update(User user) {
		User userDb = jdbcUserDao.findUserByEmail(user.getEmail());
		if (user.getRole() != null && !user.getPasswd().isEmpty() && !user.getEmail().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && userDb == null) {
			jdbcUserDao.update(user);
		} else {
			return "redirect:/edit?id=" + user.getId();
		}
		return "redirect:/admin";
	}

	public String delete(User user) {
		User userDb = jdbcUserDao.getById(user.getId());
		jdbcUserDao.deleteById(userDb.getId());
		return "redirect:/admin";
	}

	public String authorize(User user) {
		User userDb = jdbcUserDao.findUserByEmailPass(user.getEmail(), user.getPasswd());
		if (userDb.getRole().name().equals(Role.USER.name())) {
			return "redirect:/user";
		} else if (userDb.getRole().name().equals(Role.ADMIN.name())) {
			return "redirect:/admin";
		}
		return "redirect:/login";
	}
}