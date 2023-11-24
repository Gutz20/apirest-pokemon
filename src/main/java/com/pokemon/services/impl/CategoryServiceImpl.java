package com.pokemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.models.Category;
import com.pokemon.repository.CategoryRepository;
import com.pokemon.services.ICategoryService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Category save(Category categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public Category update(Long id, Category categoryEntity) {
        Category categoryFound = categoryRepository.findById(id).orElseThrow();

        categoryFound.setName(categoryEntity.getName());

        return categoryRepository.save(categoryFound);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> idsList) {
        System.out.println(idsList);
        categoryRepository.deleteAllById(idsList);
    }

}
