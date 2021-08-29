//package edu.lysenko.catalog;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import edu.lysenko.catalog.config.WebConfig;
//import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
//import edu.lysenko.catalog.entity.Task;
//import edu.lysenko.catalog.entity.User;
//
//public class Main {
//
//	public static void main(String[] args) {
//
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
//
//		WebConfig config = context.getBean(WebConfig.class);
//
//		User user = new User("email", "pass", "name", "surname", Arrays.asList(new Task()), "USER");
//
//		JdbcUserDao userDao = new JdbcUserDao(config.encoder());
//
//		userDao.save(user);
//
//		User userDb = userDao.getById(user.getId());
//		System.out.println(userDb);
//
//		System.out.println(userDao.findUserByEmailPass(userDb.getEmail(), userDb.getPassword()));
//
//	}
//}
