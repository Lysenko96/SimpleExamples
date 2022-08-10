package org.example;

import org.example.config.Config;
import org.example.dao.PersonDao;
import org.example.dao.jdbc.JdbcPersonDao;
import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ComponentScan("org.example.config")
public class Startup {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Startup.class);
        System.out.println(context);
        Config config = context.getBean(Config.class);
        System.out.println(config);
        DataSource ds = config.dataSource();
        System.out.println(ds);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
        System.out.println(conn);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        System.out.println(jdbcTemplate);
        PersonDao personDao = new JdbcPersonDao(jdbcTemplate, context);
        Person person = new Person("name", "surname", 1991, "login", "anton1234", "mail.gmail.com", 911);
        personDao.add(person);
        personDao.add(person);
        //person = personDao.getById(1);
        System.out.println(person);
        person = new Person(person.getId(), "name2", "surname2", 1991, "login2", "anton123455", "mail.gmail.com2", 912);
        personDao.update(person);
        person = personDao.getById(1);
        System.out.println(person);
        System.out.println(personDao.getAll());
        personDao.deleteById(person.getId());
        System.out.println(personDao.getAll());
    }
}
