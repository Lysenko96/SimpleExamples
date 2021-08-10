package edu.lysenko.catalog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@Service
public class UserService {

	private Logger log = Logger.getLogger(UserService.class.getName());
	@Autowired
	private JdbcUserDao userDao;

	public String getRegisterateMapping(User user) {
		List<String> emails = new ArrayList<>();

		if (!userDao.getAll().isEmpty()) {
			for (User line : userDao.getAll()) {
				emails.add(line.getEmail());
			}
		}
		if (!emails.contains(user.getEmail())) {
			userDao.add(user);
		}
		log.info(user.toString());
		User userDb = userDao.getUserData(user.getEmail(), user.getPasswd(), user.getName(), user.getSurname());
		if (userDb == null) {
			return "registerate";
		} else if (userDb.getRole().equals(Role.USER)) {
			return "user";
		} else if (userDb.getRole().equals(Role.ADMIN)) {
			return "admin";
		}
		return "registerate";
	}

	public String getLoginMapping(User user) {
		log.info(user.toString());
		User userDb = userDao.getUserData(user.getEmail(), user.getPasswd(), user.getName(), user.getSurname());
		if (userDb == null) {
			return "login";
		} else if (userDb.getRole().name().equals(Role.USER.name())) {
			return "user";
		} else if (userDb.getRole().name().equals(Role.ADMIN.name())) {
			return "admin";
		}
		return "login";
	}

}
