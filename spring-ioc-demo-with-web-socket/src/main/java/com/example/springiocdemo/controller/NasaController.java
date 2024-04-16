package com.example.springiocdemo.controller;

import com.example.springiocdemo.model.Client;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nasa/spring")
public class NasaController {

    private Client client;

    @Autowired
    public NasaController(Client client) {
        this.client = client;
    }

    @GetMapping
    public List<JsonNode> getStrings(){
        return client.getStrings();
    }
}
