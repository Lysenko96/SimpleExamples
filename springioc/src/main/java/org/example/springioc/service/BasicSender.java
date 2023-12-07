package org.example.springioc.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary
public class BasicSender implements Sender {

    @Override
    public void send() {
        System.out.println("send " + this.getClass().getSimpleName());
    }
}