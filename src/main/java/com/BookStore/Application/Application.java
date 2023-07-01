package com.BookStore.Application;

import com.BookStore.Application.model.Book;
import com.BookStore.Application.model.Category;
import com.BookStore.Application.repository.BookRepository;
import com.BookStore.Application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Category cat= new Category(null,"Informatica", "Livro de TI");
		Book book= new Book (null, "Os jovens Perguntam ","Testemunhas de Jeová", "Como terminar um relacionamento", cat);
		cat.getBooks().addAll(Arrays.asList(book));

		this.bookRepository.saveAll(Arrays.asList(book));
		this.categoryRepository.saveAll(Arrays.asList(cat));
	}
}
