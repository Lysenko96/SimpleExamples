package com.example.springjwt.service;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.util.JSON;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonArray;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@PropertySource("classpath:application.yaml")
@Transactional
public class MainService {

    private final MongoTemplate mongoTemplate;
    @Value("${path_to_json}")
    private String PATH_TO_JSON;

    public MainService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> getSalesAndTrafficByAsin() {
        List<Document> documents = new ArrayList<>();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByAsin", Document.class);
        for (Document doc : findIterable) documents.add(doc);
        return documents;
    }

    public Document getSalesAndTrafficByAsinParent(String parentAsin) {
        Document document = new Document();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByAsin", Document.class);
        for (Document doc : findIterable) {
            if (doc.getString("parentAsin").equals(parentAsin)) document = doc;
        }
        return document;
    }

    public Document getSalesAndTrafficByDateForDate(String date) {
        Document document = new Document();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByDate", Document.class);
        for (Document doc : findIterable) {
            if (doc.getString("date").equals(date)) document = doc;
        }
        return document;
    }

    public List<Document> getSalesAndTrafficByDate() {
        List<Document> documents = new ArrayList<>();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByDate", Document.class);
        for (Document doc : findIterable) documents.add(doc);
        return documents;
    }

    public void uploadTestReport() {
        BufferedReader reader;
        String lines;
        try {
            reader = new BufferedReader(new FileReader(PATH_TO_JSON));
            StringBuilder json = new StringBuilder();
            while ((lines = reader.readLine()) != null) {
                json.append(lines);
            }
            DBObject dbObject = BasicDBObject.parse(json.toString());
            mongoTemplate.insert(dbObject, "test_report");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
