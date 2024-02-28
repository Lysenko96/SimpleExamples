package org.example.petproject.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
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
@ComponentScan("org.example.petproject")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "org.example.petproject.repository",
        entityManagerFactoryRef = "resumeEntityManagerFactory",
        transactionManagerRef = "resumeTransactionManager")
@EnableTransactionManagement
@Slf4j
public class RootConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver}")
    private String driver;

    @Bean("resumeEntityManagerFactory")
    public EntityManagerFactory resumeEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("org.example.petproject.entity");
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

    @Bean("resumeTransactionManager")
    public TransactionManager resumeTransactionManager() {
        return new JpaTransactionManager(resumeEntityManagerFactory());
    }

    public Properties jpaProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = RootConfig.class
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
