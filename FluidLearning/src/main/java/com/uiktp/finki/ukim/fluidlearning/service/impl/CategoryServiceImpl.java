package com.uiktp.finki.ukim.fluidlearning.service.impl;

import com.uiktp.finki.ukim.fluidlearning.models.Category;
import com.uiktp.finki.ukim.fluidlearning.models.dto.CategoryDto;
import com.uiktp.finki.ukim.fluidlearning.models.exceptions.CategoryNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.repository.CategoryRepository;
import com.uiktp.finki.ukim.fluidlearning.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> save(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return Optional.of(this.categoryRepository.save(category));
    }

    @Override
    public Optional<Category> save(CategoryDto categoryDto) {
        this.categoryRepository.deleteByName(categoryDto.getName());
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return Optional.of(this.categoryRepository.save(category));
    }

    @Override
    public Optional<Category> edit(Integer id, String name, String description) {
        Category category = this.categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
        category.setName(name);
        category.setDescription(description);
        return Optional.of(this.categoryRepository.save(category));
    }

    @Override
    public Optional<Category> edit(Integer id, CategoryDto categoryDto) {
        Category category = this.categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        this.categoryRepository.save(category);
        return Optional.of(category);
    }

    @Override
    public void deleteById(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}
