package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Category;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CategoryDto;

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
