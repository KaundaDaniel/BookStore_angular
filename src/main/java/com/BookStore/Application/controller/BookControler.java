package com.BookStore.Application.controller;

import com.BookStore.Application.model.Book;
import com.BookStore.Application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookControler {
    @Autowired

    private BookService bookService ;
    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book= bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }
}
