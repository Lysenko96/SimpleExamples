package com.lysenko.shoppingcart.service;

import com.lysenko.shoppingcart.model.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

    Boolean existCategory(String name);

    boolean deleteById(Long id);

    Category findById(Long id);

    Category findByName(String name);

    List<Category> findAllActive();
}
