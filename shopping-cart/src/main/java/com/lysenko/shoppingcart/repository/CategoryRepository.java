package com.lysenko.shoppingcart.repository;

import com.lysenko.shoppingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Boolean existsByName(String name);

    Category findByName(String name);

    List<Category> findAllByIsActiveTrue();
}
