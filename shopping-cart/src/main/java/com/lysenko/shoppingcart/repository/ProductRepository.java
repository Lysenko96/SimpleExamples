package com.lysenko.shoppingcart.repository;

import com.lysenko.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIsActiveTrueAndCategoryIgnoreCase(String category);

    List<Product> findAllByIsActiveTrue();
}
