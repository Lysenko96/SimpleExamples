package com.example.schedulespringboot;

import com.example.schedulespringboot.task.CronScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ScheduleSpringBootApplication {

    public static void main(String[] args) {

      ConfigurableApplicationContext context = SpringApplication.run(ScheduleSpringBootApplication.class, args);
        CronScheduler cronScheduler = context.getBean("cronScheduler", CronScheduler.class);
        cronScheduler.executeTask();
    }

}
