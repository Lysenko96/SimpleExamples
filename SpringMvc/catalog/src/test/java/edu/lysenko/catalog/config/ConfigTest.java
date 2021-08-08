package edu.lysenko.catalog.config;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/configtest.properties")
@Import(Config.class)
@ContextConfiguration(classes = { Config.class })
public class ConfigTest extends Config {

	@Test
	void beanExistTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		assertThatBeanExists(context, "dataSource", DataSource.class);
		assertThatBeanExists(context, "databasePopulator", ResourceDatabasePopulator.class);
		assertThatBeanExists(context, "jdbcTemplate", JdbcTemplate.class);
	}

	private void assertThatBeanExists(AnnotationConfigApplicationContext context, String beanName, Class<?> beanClass) {
		Assertions.assertTrue(context.containsBean(beanName));
		Assertions.assertNotNull(context.getBean(beanClass));
	}
}
