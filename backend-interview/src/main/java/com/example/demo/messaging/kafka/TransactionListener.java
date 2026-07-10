package com.example.demo.messaging.kafka;

import com.example.demo.model.Transaction;
import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    // TODO

//    private final ApplicationEventPublisher applicationEventPublisher;
//
//    public TransactionListener(ApplicationEventPublisher applicationEventPublisher) {
//        this.applicationEventPublisher = applicationEventPublisher;
//    }
//
//    public void publishCreated(Long transactionId) {
//        applicationEventPublisher.publishEvent(new Event());
//    }
//
//    public void publishUpdated(Long transactionId) {
//        applicationEventPublisher.publishEvent(new Event());
//    }

//    private final KafkaTemplate<String, Transaction> kafkaTemplate;
//
//    public TransactionListener(KafkaTemplate<String, Transaction> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @EventListener
//    public void onTransactionCreate(Transaction transactionCreate) {
//        kafkaTemplate.send("transactionCreate", transactionCreate);
//    }
//
//    @EventListener
//    public void onTransactionUpdate(Transaction transactionUpdate) {
//        kafkaTemplate.send("transactionUpdate", transactionUpdate);
//    }
}
