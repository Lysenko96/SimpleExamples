//package hibernate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import hibernate.config.Provider;
//import hibernate.dao.impl.TaskDaoImpl;
//import hibernate.dao.impl.UserDaoImpl;
//import hibernate.entity.Task;
//import hibernate.entity.User;
//import hibernate.script.ScriptRunner;
//
//public class Main {
//
//	public static void main(String[] args) throws ClassNotFoundException {
//
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Provider.class);
//
//		Provider provider = context.getBean(Provider.class);
//
//		new ScriptRunner(provider).run("schema.sql");
//		TaskDaoImpl taskDao = new TaskDaoImpl();
//		UserDaoImpl userDao = new UserDaoImpl();
//		List<Task> tasks = new ArrayList<>();
//		Task task = new Task(1, "tag4", "title", null);
//		Task task2 = new Task(2, "tag3", "title2", null);
//		tasks.add(task);
//		tasks.add(task2);
//		List<User> users = new ArrayList<>();
//		User user = new User(1, "email1", "passwd", "name", "surname", tasks, "USER");
//		users.add(user);
//		task.setUsers(users);
//		task2.setUsers(users);
//		userDao.save(user);
//		taskDao.save(task);
//		taskDao.save(task2);
////		System.out.println(taskDao.getAll());
////		System.out.println(userDao.getAll());
//		System.out.println(userDao.findUserByEmailPass("email1", user.getPassword()));
//		context.close();
//	}
//}
