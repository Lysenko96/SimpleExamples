package edu.lysenko.catalog;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.lysenko.catalog.config.Config;
import edu.lysenko.catalog.controller.AppController;
import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.dao.jdbc.mapper.UserMapper;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

public class Main {

	public static void main(String[] args) throws ScriptException, SQLException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Config config = context.getBean(Config.class);

		DataSource dataSource = config.dataSource();

		ResourceDatabasePopulator databasePopulator = config.databasePopulator(dataSource);

		JdbcTemplate jdbcTemplate = config.jdbcTemplate(databasePopulator, dataSource);

		PasswordEncoder encoder = new BCryptPasswordEncoder(12);

		UserDao userDao = new JdbcUserDao(jdbcTemplate, new UserMapper());

		AppController app = new AppController();

		System.out.println(encoder.matches(("user"), encoder.encode("user")));

		userDao.add(new User("admin@gmail.com", encoder.encode("admin"), "admin", "admin", Role.ADMIN));

		System.out.println(userDao.getAll());

		context.close();
	}
}
