package com.example.webflux.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("task")
@Data
public class Task {

    @MongoId
    private String id;
    private String tag;
    private String description;
}
