package com.example.demo.messaging.kafka;

import com.example.demo.model.Transaction;
import org.apache.kafka.clients.consumer.internals.events.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TransactionListener {

    // TODO

    private static final String KEY_CREATE = UUID.randomUUID().toString();
    private static final String KEY_UPDATE = UUID.randomUUID().toString();

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TransactionListener(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @EventListener
    public void onTransactionCreate(Transaction transactionCreate) {
        kafkaTemplate.send("transactionCreate", KEY_CREATE, transactionCreate.toString());
    }

    @EventListener
    public void onTransactionUpdate(Transaction transactionUpdate) {
        kafkaTemplate.send("transactionUpdate", KEY_UPDATE, transactionUpdate.toString());
    }
}
