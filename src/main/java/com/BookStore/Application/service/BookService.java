package com.BookStore.Application.service;

import com.BookStore.Application.exceptions.ObjectNotfound;
import com.BookStore.Application.model.Book;
import com.BookStore.Application.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book findById(Long id){
        Optional<Book> book=bookRepository.findById(id);
        return book.orElseThrow(()-> new ObjectNotfound("Livro não encontrado com o número: " + id +" " + Book.class.getName()));
    }
}
