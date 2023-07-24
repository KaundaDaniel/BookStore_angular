package com.BookStore.Application.controller;

import com.BookStore.Application.dtos.BookDto;
import com.BookStore.Application.model.Book;
import com.BookStore.Application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

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
@GetMapping
    public ResponseEntity<List<BookDto>> findAll(@RequestParam (value = "category", defaultValue = "0") Long id_cat){
        List<Book> listBook= bookService.findAll(id_cat);
        List<BookDto> bookDtoList= listBook.stream().map(book -> new BookDto(book)).collect(Collectors.toList());
        return ResponseEntity.ok().body(bookDtoList);
    }
}
