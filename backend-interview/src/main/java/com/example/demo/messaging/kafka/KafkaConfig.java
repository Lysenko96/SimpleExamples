package com.example.demo.messaging.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name("transaction-created-events-topic")
                .partitions(2)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }

    @Bean
    public NewTopic updateTopic() {
        return TopicBuilder.name("transaction-updated-events-topic")
                .partitions(2)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }
}
