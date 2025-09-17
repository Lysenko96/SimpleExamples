package pckg.model;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.function.Consumer;

@DisallowConcurrentExecution
public class GenericJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("####EXECUTE");
        ((Consumer) context.getJobDetail().getJobDataMap().get("consumer")).accept(context);
    }
}
