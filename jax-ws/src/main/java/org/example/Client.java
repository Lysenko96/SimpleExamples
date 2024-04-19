package org.example;

import org.example.generated.SimpleWebService;
import org.example.generated.SimpleWebServiceImplService;
import org.example.generated.user.UserWebService;
import org.example.generated.user.UserWebServiceImplService;

public class Client {

    public static void main(String[] args) {
        SimpleWebServiceImplService simpleWebServiceImplService = new SimpleWebServiceImplService();
        SimpleWebService service = simpleWebServiceImplService.getSimpleWebServiceImplPort();
        System.out.println(service.hello());
        System.out.println(service.checkJob("programmer"));
        System.out.println(service.checkJob("it"));

        UserWebServiceImplService userWebServiceImplService = new UserWebServiceImplService();
        UserWebService userWebService = userWebServiceImplService.getUserWebServiceImplPort();

        userWebService.findAll().forEach(System.out::println);
    }
}
