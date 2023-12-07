package org.example.springioc.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class AdvanceSender implements Sender {
    @Override
    public void send() {
        System.out.println("send " + this.getClass().getSimpleName());
    }
}
