package org.example.jparelations;

import org.example.jparelations.config.Config;
import org.example.jparelations.entity.Husband;
import org.example.jparelations.entity.Wife;
import org.example.jparelations.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PersonService personService = context.getBean("personService", PersonService.class);

        Husband husband = new Husband("name", "surname", "234251", "email", "job");
        Wife wife = new Wife("namewife", "surnamewife", "234252", "email3", "job3", husband);


        personService.saveWife(wife);
        personService.saveHusband(husband);

      //  Husband husbandDb = personService.getHusbandById(1L);
        personService.deleteHusbandById(1L);
//        System.out.println(husbandDb);
//        System.out.println(husbandDb.getWife());
//        System.out.println(husbandDb.getWife().getHusband());

        //personService.deleteHusbandById(1L);
        //personService.deleteWifeById(1L);


    }
}
