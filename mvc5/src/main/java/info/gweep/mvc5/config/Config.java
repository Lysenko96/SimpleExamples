package info.gweep.mvc5.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@EnableJpaRepositories("info.gweep.mvc5.repository")
@EnableTransactionManagement
public class Config {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl_auto;
    @Value("${hibernate.show_sql}")
    private String show_sql;
    @Value("${hibernate.format_sql}")
    private String format_sql;
    @Value("classpath:schema.sql")
    private Resource schema;
    @Value("classpath:data.sql")
    private Resource data;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("info.gweep.mvc5.entity");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(additionalProperties());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getNativeEntityManagerFactory();
    }

    @Bean
    public ResourceDatabasePopulator populator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schema, data);
        populator.execute(dataSource());
        return populator;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }


    private Properties additionalProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        hibernateProperties.setProperty("hibernate.show_sql", show_sql);
        hibernateProperties.setProperty("hibernate.format_sql", format_sql);
        return hibernateProperties;
    }
}

