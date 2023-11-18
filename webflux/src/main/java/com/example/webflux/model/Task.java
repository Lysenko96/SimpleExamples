package com.example.webflux.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("task")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    @MongoId
    private String id;
    private String tag;
    private String description;
}
