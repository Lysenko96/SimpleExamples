package net.hairservice;

import net.hairservice.config.Config;
import net.hairservice.controllers.ClientController;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class HairServiceTest {

    @Test
    void beanExistTest() {
        ConfigurableApplicationContext context = SpringApplication.run(HairServiceApplication.class);
        assertThatBeanExists(context, "config", Config.class);
        assertThatBeanExists(context, "datasource", DataSource.class);
        assertThatBeanExists(context, "flyway", Flyway.class);
        assertThatBeanExists(context, "populator", ResourceDatabasePopulator.class);
        assertThatBeanExists(context, "jdbcTemplate", JdbcTemplate.class);
    }

    private void assertThatBeanExists(ConfigurableApplicationContext context, String beanName, Class<?> beanClass) {
        Assertions.assertTrue(context.containsBean(beanName));
        Assertions.assertNotNull(context.getBean(beanClass));
    }
}
