package edu.lysenko.catalog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;

@Configuration
@EnableWebMvc
@ComponentScan("edu.lysenko.catalog")
@PropertySource("classpath:config.properties")
public class WebConfig implements WebMvcConfigurer {

	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.passwd}")
	private String passwd;
	@Value("${db.driver}")
	private String driver;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, passwd);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user").setViewName("user");
	}

	@Bean
	JdbcUserDao userDao() {
		return new JdbcUserDao(getDataSource());
	}
}
