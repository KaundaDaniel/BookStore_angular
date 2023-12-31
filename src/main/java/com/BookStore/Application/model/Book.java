package com.BookStore.Application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Book implements Serializable {

@Serial
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, max = 50, message = "O Titulo deve ser preenchido")
    private String title;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, max = 50, message = "O nome deve ser preenchido")
    private String name_author;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, message = "O nome deve ser preenchido")
    private String text;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(Long id, String title, String name_author, String text, Category category) {
        this.id = id;
        this.title = title;
        this.name_author = name_author;
        this.text = text;
        this.category = category;
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

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
