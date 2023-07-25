package com.BookStore.Application.controller;

import com.BookStore.Application.dtos.CatergoryDto;
import com.BookStore.Application.model.Category;
import com.BookStore.Application.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CatergoryDto>> findAll() {
        List<Category> list = categoryService.findAll();
        List<CatergoryDto> listDto = list
                .stream()
                .map(object -> new CatergoryDto(object))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
        category = categoryService.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<CatergoryDto>update(@Valid @PathVariable Long id, @RequestBody CatergoryDto catergoryDto){
        Category category= categoryService.update(id, catergoryDto);
        return ResponseEntity.ok().body(new CatergoryDto(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
