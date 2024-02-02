package org.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.example.demo")
@EnableJpaRepositories(basePackages = "org.example.demo.repository",
        entityManagerFactoryRef = "customEntityManager",
        transactionManagerRef = "customTransactionManager")
@EnableTransactionManagement
@Slf4j
public class Config {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver}")
    private String driver;

    @Bean("customEntityManager")
    public EntityManagerFactory customEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("org.example.demo.entity");
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setJpaProperties(jpaProperties());
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("customTransactionManager")
    public TransactionManager customTransactionManager() {
        return new JpaTransactionManager(customEntityManagerFactory());
    }

    public Properties jpaProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = Config.class
                .getClassLoader()
                .getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            log.error(String.valueOf(e));
        }
        return null;
    }
}
