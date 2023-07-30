package org.example.springioc3;

import org.example.springioc3.config.Config;
import org.example.springioc3.entity.Target;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Target target = context.getBean(Target.class);
        System.out.println(target);
        context.close();
    }
}
