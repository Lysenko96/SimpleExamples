package org.example.mvcapp;

import org.example.mvcapp.dto.Message;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class StartupMvc {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //HttpEntity<Message> httpRequest = new HttpEntity<>(new Message("text", "author"), headers);
        try {
            RequestEntity<Message> requestEntity = new RequestEntity<>(new Message("text", "author"), HttpMethod.POST, new URI("http://localhost:8080/messages"));
           // restTemplate.postForLocation("http://localhost:8080/messages", requestEntity);
            ResponseEntity<Message> responseEntity = restTemplate.exchange(new URI("http://localhost:8080/messages"), HttpMethod.POST, requestEntity, Message.class);
            System.out.println(responseEntity);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        //restTemplate.postForObject("http://localhost:8080/messages", httpRequest, String.class);
    }
}
