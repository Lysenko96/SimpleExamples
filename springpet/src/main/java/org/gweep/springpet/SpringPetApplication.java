package org.gweep.springpet;

import org.apache.catalina.core.ApplicationContext;
import org.gweep.springpet.dao.PersonDao;
import org.gweep.springpet.dao.jdbc.JdbcPersonDao;
import org.gweep.springpet.model.Person;
import org.gweep.springpet.provider.Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class SpringPetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPetApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Provider.class);
        Provider provider = context.getBean("provider", Provider.class);
        PersonDao personDao = new JdbcPersonDao(provider.getJdbcTemplate());
        personDao.save(new Person());
    }

}
