package com.BookStore.Application.controller;

import com.BookStore.Application.dtos.BookDto;
import com.BookStore.Application.model.Book;
import com.BookStore.Application.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@Valid @PathVariable Long id,  @RequestBody Book book){
        Book  bookNew= bookService.update(id, book);
        return ResponseEntity.ok().body(bookNew);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePatch(@Valid @PathVariable Long id, @RequestBody  Book book1){
    Book bookNew= bookService.update(id, book1);
    return ResponseEntity.ok().body(bookNew);
    }

    @PostMapping
    public ResponseEntity<Book>create(@Valid @RequestParam(value = "category", defaultValue = "0")
                                          Long id_cat, @RequestBody Book newBook){
        Book newBook2=bookService.create(id_cat, newBook);
        URI uri= ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(newBook2.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
