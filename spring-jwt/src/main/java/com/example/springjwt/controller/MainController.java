package com.example.springjwt.controller;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.BsonNull;
import org.bson.Document;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@RestController
@Slf4j
public class MainController {

    private MongoTemplate mongoTemplate;

    public MainController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/salesAndTrafficByAsin")
    @Cacheable("getSalesAndTrafficByAsin")
    public List<Document> getSalesAndTrafficByAsin(){
        List<Document> documents = new ArrayList<>();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByAsin", Document.class);
        for(Document doc : findIterable) documents.add(doc);
        return documents;
    }

    @GetMapping("/salesAndTrafficByDate")
    @Cacheable("getSalesAndTrafficByDate")
    public List<Document> getSalesAndTrafficByDate() {
        List<Document> documents = new ArrayList<>();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByDate", Document.class);
        for(Document doc : findIterable) documents.add(doc);
        return documents;
    }

    @GetMapping("/resetCache")
    @CacheEvict(cacheNames = {"getSalesAndTrafficByAsin", "getSalesAndTrafficByDate"})
    public String resetCache(){
        return "Reset cache";
    }

    @GetMapping("/admin")
    public String adminData() {
        return "Admin data";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
