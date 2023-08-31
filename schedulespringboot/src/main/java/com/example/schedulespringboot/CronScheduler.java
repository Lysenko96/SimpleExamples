package com.example.schedulespringboot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CronScheduler {

    private static int i;
    private static int j;
    private static int k;


    // fixedDelay wait while thread sleep end and run again
    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedDelayString = "${schedule.fixed-delay}")
    public void runOne(){
        System.out.println("run One: " + ++i);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run One increment: " + ++i);
    }

    // fixedRate don't wait thread sleep end and run again
    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 1, fixedRateString = "${schedule.fixed-rate}")
    public void runTwo(){
        System.out.println("run Two: " + ++j);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run Two increment: " + ++j);
    }

    // work how fixedRate
    @Scheduled(cron = "${schedule.cron}")
    public void runThree(){
        System.out.println("run Three : " + ++k);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run Three increment : " + ++k);

    }
}
