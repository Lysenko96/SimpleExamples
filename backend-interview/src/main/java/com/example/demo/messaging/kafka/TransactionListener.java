package com.example.demo.messaging.kafka;

import com.example.demo.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class TransactionListener {

    private static final String KEY_CREATE = UUID.randomUUID().toString();
    private static final String KEY_UPDATE = UUID.randomUUID().toString();

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public TransactionListener(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @EventListener
    public void onTransactionCreate(Transaction create) throws ExecutionException, InterruptedException {
        SendResult<String, Event> mapCreated = kafkaTemplate.send("ransaction-created-events-topic", KEY_CREATE,
                new Event(create.getId(), create.getStatus(), create.getAmount())).get();
        log.info("onTransactionCreate result: {}", mapCreated);
    }

    @EventListener
    public void onTransactionUpdate(Transaction update) throws ExecutionException, InterruptedException {
        SendResult<String, Event> mapCreated = kafkaTemplate.send("ransaction-updated-events-topic", KEY_UPDATE,
                new Event(update.getId(), update.getStatus(), update.getAmount())).get();
        log.info("onTransactionUpdate result: {}", mapCreated);
    }
}
