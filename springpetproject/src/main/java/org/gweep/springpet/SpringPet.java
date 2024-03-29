package org.gweep.springpet;


import org.gweep.springpet.dao.PersonDao;
import org.gweep.springpet.dao.jdbc.JdbcPersonDao;
import org.gweep.springpet.model.Person;
import org.gweep.springpet.model.Role;
import org.gweep.springpet.model.Status;
import org.gweep.springpet.model.Task;
import org.gweep.springpet.provider.Provider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringPet {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Provider.class);
        System.out.println(context);
        Provider provider = context.getBean("provider", Provider.class);
        System.out.println(provider);
        System.out.println(provider.jdbcTemplate());
        DataSource dataSource = provider.jdbcTemplate().getDataSource();

        if(dataSource != null) provider.databasePopulator().execute(dataSource);

        PersonDao personDao = new JdbcPersonDao(provider.jdbcTemplate());
        personDao.save(new Person("firstname", "lastname", "login", "password", 2000, "email", "address", "937-99-92", Role.USER, Arrays.asList(new Task("task", "fixed bug", Status.CODING), new Task("task1", "refactor", Status.TESTING))));
//        personDao.save(new Person("firstname2", "lastname2", "login2", "password2", 2002, "email", "address", "937-99-92", Role.USER, Arrays.asList(new Task("task", "testing", Status.CODE_REVIEW))));
//        personDao.update(new Person(1,"firstname1", "lastname1", "login1", "password1", 2001, "email1", "address1", "937-99-92", Role.ADMIN, Arrays.asList(new Task())));
//        System.out.println(personDao.getById(2));
//        System.out.println(personDao.getAll());
//        personDao.deleteById(2);
        System.out.println(personDao.getAll());
    }

}
