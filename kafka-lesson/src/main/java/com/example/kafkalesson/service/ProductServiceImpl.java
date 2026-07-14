package com.example.kafkalesson.service;

import com.example.kafkalesson.dto.CreateProductDto;
import com.example.kafkalesson.event.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {

    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductDto productDto) throws ExecutionException, InterruptedException {
        //TODO save to datbase
        String productId = UUID.randomUUID().toString();
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, productDto.getTitle(),
                productDto.getPrice(), productDto.getQuantity());
        // async
//        CompletableFuture<SendResult<String, ProductCreatedEvent>> future = kafkaTemplate
//                .send("transaction-created-events-topic", productId, productCreatedEvent);
//        future.whenComplete((result, ex) -> {
//            if (ex != null) {
//                LOG.error("Failed to send message: ", ex);
//            } else {
//                LOG.info("Message send successfully:{}", result.getRecordMetadata());
//            }
//        });

        // sync
        SendResult<String, ProductCreatedEvent> result = null;
        result = kafkaTemplate.send("transaction-created-events-topic", productId, productCreatedEvent).get();
        LOG.info("Send successfully: {}", result);
        LOG.info("Return:{}", productId);
        return productId;
    }
}
