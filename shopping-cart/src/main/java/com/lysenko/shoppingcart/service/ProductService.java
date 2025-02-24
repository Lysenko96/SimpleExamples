package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    boolean delete(Long id);
}
