package edu.lysenko.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	@Autowired
	private JdbcUserDao userDao;

	public String save(User user) {
		List<String> emails = new ArrayList<>();
		if (!userDao.getAll().isEmpty()) {
			for (User entity : userDao.getAll()) {
				emails.add(entity.getEmail());
			}
		}
		if (user.getRole() != null && !user.getEmail().isEmpty() && !user.getPasswd().isEmpty()
				&& !user.getName().isEmpty() && !user.getSurname().isEmpty() && !user.getRole().name().isEmpty()
				&& !emails.contains(user.getEmail())) {
			userDao.add(user);
		}
		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPasswd());
		String mapping = null;
		if (userDb == null || user.getRole() == null || user.getPasswd().isEmpty()) {
			mapping = "redirect:/registerate";
		} else if (userDb.getRole().equals(Role.USER) && user.getRole().name().equals(Role.USER.name())) {
			mapping = "redirect:/login";
		} else if (userDb.getRole().equals(Role.ADMIN) && user.getRole().name().equals(Role.ADMIN.name())) {
			mapping = "redirect:/login";
		}
		return mapping;
	}

	public String update(User user) {
		List<String> emails = new ArrayList<>();
		if (!userDao.getAll().isEmpty()) {
			for (User entity : userDao.getAll()) {
				emails.add(entity.getEmail());
			}
		}
		String mapping = null;
		if (user.getRole() != null && !user.getPasswd().isEmpty() && !user.getEmail().isEmpty()
				&& !user.getPasswd().isEmpty() && !user.getName().isEmpty() && !user.getSurname().isEmpty()
				&& !user.getRole().name().isEmpty() && !emails.contains(user.getEmail())) {
			userDao.update(user);
		} else if (user.getPasswd().isEmpty()) {
			mapping = "redirect:/edit?id=" + user.getId();
		}
		User userDb = userDao.findUserByEmail(user.getEmail());
		userDao.update(user);
		if (userDb == null || user.getRole() == null || !user.getPasswd().isEmpty()) {
			mapping = "redirect:/login";
		} else if (userDb.getRole().equals(Role.USER) && !user.getPasswd().isEmpty()) {
			mapping = "redirect:/user";
		} else if (userDb.getRole().equals(Role.ADMIN) && !user.getPasswd().isEmpty()) {
			mapping = "redirect:/admin";
		}
		return mapping;
	}

	public String delete(User user) {
		User userDb = userDao.getById(user.getId());
		userDao.deleteById(userDb.getId());
		return "redirect:/admin";
	}

	public String authorize(User user) {
		User userDb = userDao.findUserByEmailPass(user.getEmail(), user.getPasswd());
		String mapping = null;
		if (userDb == null) {
			mapping = "redirect:/login";
		} else if (userDb.getRole().name().equals(Role.USER.name())) {
			mapping = "redirect:/user";
		} else if (userDb.getRole().name().equals(Role.ADMIN.name())) {
			mapping = "redirect:/admin";
		}
		return mapping;
	}

}
