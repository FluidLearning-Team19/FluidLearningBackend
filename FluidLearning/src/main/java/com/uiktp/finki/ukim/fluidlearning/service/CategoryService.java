package com.uiktp.finki.ukim.fluidlearning.service;

import com.uiktp.finki.ukim.fluidlearning.models.Category;
import com.uiktp.finki.ukim.fluidlearning.models.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(Integer id);
    List<Category> findAll();
    Optional<Category> save(String name, String description);
    Optional<Category> save(CategoryDto categoryDto);
    Optional<Category> edit(Integer id, String name, String description);
    Optional<Category> edit(Integer id, CategoryDto categoryDto);
    void deleteById(Integer id);
}
