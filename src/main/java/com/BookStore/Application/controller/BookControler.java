package com.BookStore.Application.controller;

import com.BookStore.Application.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookControler {
    private BookService bookService ;
}
