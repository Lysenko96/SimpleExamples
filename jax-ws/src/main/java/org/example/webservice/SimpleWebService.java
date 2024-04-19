package org.example.webservice;


import jakarta.jws.WebService;

@WebService
public interface SimpleWebService {

    String hello();

    String checkJob(String jobName);
}
