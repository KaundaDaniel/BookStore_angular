package com.BookStore.Application.controller;

import com.BookStore.Application.model.Category;
import com.BookStore.Application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category= categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
