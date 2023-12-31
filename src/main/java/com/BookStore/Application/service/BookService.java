package com.BookStore.Application.service;

import com.BookStore.Application.exceptions.ObjectNotfound;
import com.BookStore.Application.model.Book;
import com.BookStore.Application.model.Category;
import com.BookStore.Application.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;
    public Book findById(Long id){
        Optional<Book> book=bookRepository.findById(id);
        return book.orElseThrow(()-> new ObjectNotfound("Livro não encontrado com o número: " + id +" " + Book.class.getName()));
    }
    public List<Book> findAll(Long id_cat){
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book update(Long id, Book book) {
        Book bookId= findById(id);
        updateInfo(bookId, book);
        return bookRepository.save(bookId);
    }

    private void updateInfo(Book bookId, Book book) {
        bookId.setName_author(book.getName_author());
        bookId.setText(book.getText());
        bookId.setText(book.getText());
    }
    public Book create(Long id_cat ,Book book ){
        book.setId(null);
        Category cateBook=categoryService.findById(id_cat);
        book.setCategory(cateBook);
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        Book book= findById(id);
        bookRepository.deleteById(id);
    }
}
