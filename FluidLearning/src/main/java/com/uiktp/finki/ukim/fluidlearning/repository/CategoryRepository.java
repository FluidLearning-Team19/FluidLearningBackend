package com.uiktp.finki.ukim.fluidlearning.repository;

import com.uiktp.finki.ukim.fluidlearning.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    void deleteByName(String name);
}
