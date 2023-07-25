package com.BookStore.Application.dtos;

import com.BookStore.Application.model.Book;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class BookDto implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, max = 50, message = "O nome deve ser preenchido")
    private String title;

    public BookDto(){

    }
    public BookDto(Book book){
        this.id=book.getId();
        this.title= book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
