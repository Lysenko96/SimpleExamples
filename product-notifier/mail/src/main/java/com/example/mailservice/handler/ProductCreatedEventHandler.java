package com.example.mailservice.handler;

import com.example.model.event.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
@KafkaListener(topics = "transaction-created-events-topic", groupId = "transaction-created-events")
public class ProductCreatedEventHandler {

    private RestTemplate restTemplate;

    public ProductCreatedEventHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final Logger LOG = LoggerFactory.getLogger(ProductCreatedEventHandler.class);

    @KafkaHandler
    public void handle(ProductCreatedEvent event) {
//        if (true) {
//            throw new NonRetryableException("non retryable handle event error");
//        }
        LOG.info("Handle result:{}", event);

        String url = "http://localhost:8090/response/200";
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            if (response.getStatusCode().value() == HttpStatus.OK.value()) {
                LOG.info("Received response {}", response.getBody());
            }
        } catch (ResourceAccessException e) {
            LOG.error("handle ResourceAccessException error:  {}", e);
            throw new RetryableException(e);
        } catch (HttpServerErrorException e) {
            LOG.error("handle HttpServerErrorException error:  {}", e);
            throw new NonRetryableException(e);
        } catch (Exception e) {
            LOG.error("handle Exception error:  {}", e);
            throw new NonRetryableException(e);
        }
    }

}
