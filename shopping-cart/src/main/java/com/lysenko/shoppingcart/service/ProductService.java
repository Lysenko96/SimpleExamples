package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    boolean delete(Long id);

    Product findById(Long id);

    Product update(Product product, MultipartFile file) throws IOException;

    List<Product> findAllActiveByCategory(String category);

    List<Product> findAllActive();

}
