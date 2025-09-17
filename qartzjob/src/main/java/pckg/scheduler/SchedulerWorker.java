package pckg.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import pckg.model.GenericJob;

import java.util.function.Consumer;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SchedulerWorker {

    private Scheduler scheduler;
    private static final SchedulerFactory sf = new StdSchedulerFactory();

    public SchedulerWorker(String consumerKey, Consumer<?> consumer, String jobName, String jobGroup,
                           String triggerName, String triggerGroup, String cronExpression) throws SchedulerException {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(consumerKey, consumer);
        JobDetail job1 = newJob(GenericJob.class)
                .withIdentity(jobName, jobGroup)
                .setJobData(jobDataMap)
                .build();
        Trigger trigger1 = newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .startNow()
                .withSchedule(cronSchedule(cronExpression))
                .build();
        scheduler = sf.getScheduler();
        scheduler.scheduleJob(job1, trigger1);
    }

    public void start() throws SchedulerException {
        scheduler.start();
    }

    public void shutdownAll() throws SchedulerException {
        scheduler.shutdown();
    }

}
