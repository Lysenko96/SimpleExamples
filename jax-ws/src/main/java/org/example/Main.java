package org.example;

import jakarta.xml.ws.Endpoint;
import org.example.webservice.SimpleWebServiceImpl;
import org.example.webservice.user.UserWebServiceImpl;


public class Main
{
    public static void main( String[] args ) {
        Endpoint.publish("http://localhost:8080/webserice/simple", new SimpleWebServiceImpl());
        Endpoint.publish("http://localhost:8080/webserice/user", new UserWebServiceImpl());
        System.out.println("Done");
    }

}
