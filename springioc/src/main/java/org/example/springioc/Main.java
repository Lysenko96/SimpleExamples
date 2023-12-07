package org.example.springioc;

import org.example.springioc.cofig.Config;
import org.example.springioc.cofig.SenderConfig;
import org.example.springioc.entity.Human;
import org.example.springioc.entity.Job;
import org.example.springioc.service.BasicSender;
import org.example.springioc.service.EmailSender;
import org.example.springioc.service.Sender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class, SenderConfig.class);
//        Job job = context.getBean("job", Job.class);
//        job.setName("java developer");
//        //Human human = context.getBean("humanWithJob", Human.class);
//        Human human2 = context.getBean("human", Human.class);
//        //human.setJob(job);
//        //System.out.println(human);
//        System.out.println(human2);

        EmailSender emailSender = context.getBean("emailSender", EmailSender.class);
        EmailSender emailSender2 = context.getBean("emailSender", EmailSender.class);
//        BasicSender basicSender = context.getBean("basicSender", BasicSender.class);
//        BasicSender basicSender2 = context.getBean("basicSender", BasicSender.class);
//        emailSender.setBasicSender(basicSender);
//        emailSender2.setBasicSender(basicSender);
        //emailSender.setSenders(List.of(basicSender));
        System.out.println(emailSender);
        System.out.println(emailSender2);

        emailSender.sendEmail();

        context.close();
    }
}
