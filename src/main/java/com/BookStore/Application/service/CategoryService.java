package com.BookStore.Application.service;

import com.BookStore.Application.dtos.CatergoryDto;
import com.BookStore.Application.exceptions.DataIntegrityException;
import com.BookStore.Application.model.Category;
import com.BookStore.Application.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.BookStore.Application.exceptions.ObjectNotfound;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category findById(Long id){
        Optional<Category> category=categoryRepository.findById(id);
        return  category.orElseThrow(()-> new ObjectNotfound("Categoria não encontrado com esse Id "+ id + " Tipo " + Category.class.getName()));
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category create(Category category){
        category.setId(null);
        return categoryRepository.save(category);
    }
    public Category update(Long id, CatergoryDto catergoryDto){
        Category category= findById(id);
        category.setName(catergoryDto.getName());
        category.setDescription(catergoryDto.getDescription());
        return  categoryRepository.save(category);
    }
    public void delete(Long id){
        findById(id);
    try {
        categoryRepository.deleteById(id);
    }catch (DataIntegrityViolationException e){
        throw new DataIntegrityException("categoria não pode ser apagado");
    }
    }
}
