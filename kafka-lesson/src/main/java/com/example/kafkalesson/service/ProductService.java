package com.example.kafkalesson.service;

import com.example.kafkalesson.dto.CreateProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {

    String createProduct(CreateProductDto productDto) throws ExecutionException, InterruptedException;
}
