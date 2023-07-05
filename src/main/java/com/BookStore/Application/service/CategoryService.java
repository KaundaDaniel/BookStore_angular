package com.BookStore.Application.service;

import com.BookStore.Application.model.Category;
import com.BookStore.Application.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BookStore.Application.exceptions.ObjectNotfound;

import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category findById(Long id){
        Optional<Category> category=categoryRepository.findById(id);
        return  category.orElseThrow(()-> new ObjectNotfound("Não encontrado com esse Id "+ id + " Tipo " + Category.class.getName()));
    }
}
