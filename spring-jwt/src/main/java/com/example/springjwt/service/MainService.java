package com.example.springjwt.service;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MainService {

    private final MongoTemplate mongoTemplate;

    public MainService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> getSalesAndTrafficByAsin() {
        List<Document> documents = new ArrayList<>();
        DistinctIterable<Document> findIterable = mongoTemplate.getCollection("test_report")
                .distinct("salesAndTrafficByAsin", Document.class);
        for (Document doc : findIterable) documents.add(doc);
        for (Document doc : findIterable) log.info(doc.getString("parentAsin"));
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
        // in process
//        List<InsertOneModel<Document>> docs = new ArrayList<>();
//        MongoCollection<Document> collection = mongoTemplate.getCollection("test_report");
//        try (BufferedReader br = new BufferedReader(new FileReader("/home/user/Documents/SimpleExamples/spring-jwt/src/main/resources/test_report.json"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                docs.add(new InsertOneModel<>(Document.parse(line)));
//                collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
//                docs.clear();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
    }
}
