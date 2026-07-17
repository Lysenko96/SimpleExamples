package com.example.kafkalesson.config;

import com.example.model.event.ProductCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, ProductCreatedEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(new HashMap<>(){{
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
            put(ProducerConfig.ACKS_CONFIG, "all");
            put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        }});
    }

    @Bean
    public KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("transaction-created-events-topic")
                .partitions(2)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }
}