package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Category;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CategoryDto;
import com.uiktp.finki.ukim.fluidlearning.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(value = "*")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return this.categoryService.findById(id).map(category -> ResponseEntity.ok().body(category)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    private ResponseEntity<Category> save(@RequestBody CategoryDto categoryDto){
        return this.categoryService.save(categoryDto).map(category -> ResponseEntity.ok().body(category)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<Category> edit(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        return this.categoryService.edit(id, categoryDto)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteById(@PathVariable Integer id){
        this.categoryService.deleteById(id);
        if(this.categoryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
