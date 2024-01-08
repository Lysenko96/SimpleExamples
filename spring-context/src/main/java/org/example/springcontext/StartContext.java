package org.example.springcontext;

import org.example.springcontext.service.NasaClientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartContext {

    private static AnnotationConfigApplicationContext context;
    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext("org.example.springcontext");
        //BeanWorker beanWorker = context.getBean("beanWorker", BeanWorker.class);
       //Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println(beanWorker);
        //createCustomBeanDefinition(Entity.class);
       // System.out.println("Added custom bean definition");
       // Entity entity = context.getBean(Entity.class);
        //Entity entity1 = context.getBean(Entity.class);
      //  entity.show();
        //entity1.show();

        NasaClientService nasaClientService = context.getBean(NasaClientService.class);
        nasaClientService.callNasa();
        nasaClientService.getData();
      //  nasaClientService.callNasaAsync();
       // context.close();
        //System.out.println("Done");

        System.out.println(nasaClientService.getClass());
    }

//    static void createCustomBeanDefinition(Class<?> clazz) {
//        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClass(clazz);
//        beanDefinition.setScope("prototype");
//        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
//        beanFactory.registerBeanDefinition(clazz.getName().toLowerCase(), beanDefinition);
//    }
}
