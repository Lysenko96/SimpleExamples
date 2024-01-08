package org.example.springcontext.service;

import org.example.springcontext.annotation.MethodLogging;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@MethodLogging
@Service
public class NasaClientService {

    public void callNasa(){
        System.out.println("Calling NASA...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void getData(){
        System.out.println("Get data...");
    }


    //@Async
//    public void callNasaAsync(){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
