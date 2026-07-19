package com.example.kafkalesson.config;

import com.example.model.event.ProductCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    public String bootstrapConfig;
    @Value("${spring.kafka.producer.value-serializer}")
    public String valueSerializer;
    @Value("${spring.kafka.producer.key-serializer}")
    public String keySerializer;
    @Value("${spring.kafka.producer.acks}")
    public String acks;
    @Value("${spring.kafka.producer.enable.idempotence}")
    public String idempotence;


    @Bean
    public ProducerFactory<String, ProductCreatedEvent> producerFactory() {
        return new DefaultKafkaProducerFactory<>(new HashMap<>() {{
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig);
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            put(ProducerConfig.ACKS_CONFIG, acks);
            put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, idempotence);
        }});
    }

    @Bean
    public KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate() {
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