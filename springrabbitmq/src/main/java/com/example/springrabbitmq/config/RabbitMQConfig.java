package com.example.springrabbitmq.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;
    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String queue;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue(){
        return new Queue(queue, false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedRate = 3)
    public void produce(){
        Long currentTime = new Date().getTime();
        System.out.println("produce: " + "{" + currentTime + "}");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("currentTime", currentTime);
        rabbitTemplate.convertAndSend(exchange, routingKey, String.valueOf(currentTime));
    }

//    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedRate = 3)
//    public void receive(){
//        System.out.println("receiveAndConvert: " + rabbitTemplate.receiveAndConvert(queue));
//    }
}
