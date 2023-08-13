package info.gweep.springtx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("info.gweep.springtx")
public class ServiceConfig {

    private EntityManagerFactory entityManagerFactory;

    public ServiceConfig(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    public TransactionTemplate transactionTemplate(){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_NEVER);
        transactionTemplate.setTimeout(30);
        transactionTemplate.setTransactionManager(transactionManager());
        return transactionTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
