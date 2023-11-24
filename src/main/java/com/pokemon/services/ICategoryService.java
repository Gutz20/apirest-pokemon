package com.pokemon.services;

import java.util.List;

import com.pokemon.models.Category;


public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category save(Category categoryEntity);

    Category update(Long id, Category categoryEntity);

    void deleteById(Long id);

    void deleteAllById(List<Long> idsList);
}
