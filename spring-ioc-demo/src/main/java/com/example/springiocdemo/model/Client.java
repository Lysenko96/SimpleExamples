package com.example.springiocdemo.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Log
@Component
public class Client {

    private RestTemplate restTemplate;

    public Client(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<JsonNode> getStrings(){
        List<JsonNode> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY", JsonNode.class);
        if(jsonNode != null){
            Iterator<String> it = jsonNode.fieldNames();
            while (it.hasNext()){
                result.add(jsonNode.get(it.next()));
            }
        }
        return result;
    }
}
