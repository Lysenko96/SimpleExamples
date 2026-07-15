package com.example.mailservice.handler;

import com.example.mailservice.event.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "transaction-created-events-topic")
public class ProductCreatedEventHandler {

    private final Logger LOG = LoggerFactory.getLogger(ProductCreatedEventHandler.class);

    @KafkaHandler
    public void handle(ProductCreatedEvent event) {
        LOG.info("Handle result:{}", event);
    }

}
