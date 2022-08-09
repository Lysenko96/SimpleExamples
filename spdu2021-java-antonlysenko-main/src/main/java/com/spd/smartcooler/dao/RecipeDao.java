package com.spd.smartcooler.dao;

import java.util.List;

import com.spd.smartcooler.entity.Recipe;

public interface RecipeDao {

	boolean add(Recipe recipe);

	Recipe getById(int id);

	List<Recipe> getAll();

	boolean update(Recipe recipe);

	boolean deleteById(int id);
}