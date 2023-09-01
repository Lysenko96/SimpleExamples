package com.example.springrabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RabbitMQListener {

    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String queue;

    public RabbitMQListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // use @RabbitListener or RabbitTemplate else one of them receive null

//    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
//    public void receive(String message){
//        System.out.println("receive: " + message);
//    }

    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedRate = 5)
    public void receive(){
        System.out.println("receiveAndConvert: " + rabbitTemplate.receiveAndConvert(queue));
    }

}
