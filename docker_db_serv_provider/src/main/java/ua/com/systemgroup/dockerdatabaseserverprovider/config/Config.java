package ua.com.systemgroup.dockerdatabaseserverprovider.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.com.systemgroup.dockerdatabaseserverprovider.service.csv.ExportProviderService;
import ua.com.systemgroup.dockerdatabaseserverprovider.service.csv.ImportProviderService;

@Configuration
public class Config {

    @Value("${custom.interval.seconds}")
    private Integer interval;

    @Bean
    public JobDetail jobDetailImport() {
        return JobBuilder.newJob(ImportProviderService.class)
                .withIdentity("importProviderServiceJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerImport(JobDetail jobDetailImport) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailImport)
                .withIdentity("importProviderServiceJobTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(interval)
                        .repeatForever())
                .build();
    }

    @Bean
    public JobDetail jobDetailExport() {
        return JobBuilder.newJob(ExportProviderService.class)
                .withIdentity("exportProviderServiceJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger triggerExport(JobDetail jobDetailExport) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetailExport)
                .withIdentity("exportProviderServiceJobTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(interval)
                        .repeatForever())
                .build();
    }
}
