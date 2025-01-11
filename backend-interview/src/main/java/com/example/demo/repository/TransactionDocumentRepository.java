package com.example.demo.repository;

import com.example.demo.repository.document.TransactionDocument;
import com.mongodb.DuplicateKeyException;
import org.springframework.data.mongodb.repository.MongoRepository;

// TODO use it
public interface TransactionDocumentRepository extends MongoRepository<TransactionDocument, Long> {

}
