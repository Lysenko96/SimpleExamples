package edu.tasks.jdbcspring;

import edu.tasks.jdbcspring.config.Config;
//import edu.tasks.jdbcspring.connection.ConnectionProvider;
import edu.tasks.jdbcspring.dao.CarDao;
import edu.tasks.jdbcspring.dao.jdbc.JdbcCarDao;
import edu.tasks.jdbcspring.entity.Car;
import edu.tasks.jdbcsrping.scriptrunner.ScriptRunner;

import static java.lang.System.out;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	// private static ConnectionProvider provider = new
	// ConnectionProvider("config.properties");

	// private static ConnectionProvider provider = new ConnectionProvider();
	public static void main(String[] args) {
		//Config config = new Config();

		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(Config.class);

		// ConnectionProvider provider = context.getBean("connectionProvider",
		// ConnectionProvider.class);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Config configuration = context.getBean("config", Config.class);

		
		new ScriptRunner(configuration).runSQLQueries("schema.sql");
		CarDao carDao = new JdbcCarDao(configuration.jdbcTemplate());
		Car car = new Car("tesla", 300);
		carDao.add(car);
		out.println(carDao.getById(1));
		carDao.deleteById(1);
	}

}
