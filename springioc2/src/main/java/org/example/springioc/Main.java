package org.example.springioc;

import org.example.springioc.config.Config;
import org.example.springioc.entity.Signer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Map<String, Signer> beans = context.getBeansOfType(Signer.class);

        Signer signer = context.getBean("theSigner", Signer.class);
        Signer signer2 = context.getBean("theSigner", Signer.class);
        System.out.println(signer);
        System.out.println(signer2);
        System.out.println(signer.equals(signer2)); // true if @EqualsAndHashCode
        System.out.println(signer == signer2); // false

        beans.forEach((key, value) -> System.out.println("value: " + value + System.lineSeparator() +
                "key: " + key + System.lineSeparator() +
                "aliases: " + Arrays.toString(context.getAliases(key))));
    }
}
