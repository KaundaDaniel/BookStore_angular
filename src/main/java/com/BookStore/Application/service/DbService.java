package com.BookStore.Application.service;

import com.BookStore.Application.model.Book;
import com.BookStore.Application.model.Category;
import com.BookStore.Application.repository.BookRepository;
import com.BookStore.Application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public void instaciarBaseDados() {
        Category cat = new Category(null, "Informatica", "Livro de TI");
        Book book = new Book(null, "Os jovens Perguntam ", "Testemunhas de Jeová", "Como terminar um relacionamento", cat);
        Category cat2 = new Category(null, "Economia", "Finanças e Poupança");

        Book book2 = new Book(null, "cabra da minha Mãe ", "Gilberto Armando", "Dinheiro ajuda o povo", cat2);
        Category cat3 = new Category(null, "Religioso", "Uma abordagem do Mundo Cristão");
        Category cat4 = new Category(null, "Telecomunicação", "Uma abordagem pelas antenas");

        Book book3 = new Book(null, "O que a Biblia realmente Ensina ", "Jeová nosso Deus", "Este curso biblico ajuda voce a de achegar mais de Jeova", cat3);

        cat.getBooks().addAll(Arrays.asList(book, book2,book3));

        this.categoryRepository.saveAll(Arrays.asList(cat, cat2, cat3, cat4));

        this.bookRepository.saveAll(Arrays.asList(book, book2, book3));

    }
}
