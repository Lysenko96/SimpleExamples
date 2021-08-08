package edu.lysenko.catalog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@ComponentScan("edu.lysenko.catalog")
@PropertySource("classpath:config.properties")
public class Config {

	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.passwd}")
	private String passwd;
	
	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource(url, user, passwd);
	}

	@Bean
	public ResourceDatabasePopulator databasePopulator(DataSource dataSource) {
		return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
	}

	@Bean
	@Scope(value = "prototype")
	public JdbcTemplate jdbcTemplate(ResourceDatabasePopulator databasePopulator, DataSource dataSource) {
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return new JdbcTemplate(dataSource);
	}
}