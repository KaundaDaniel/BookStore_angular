package com.BookStore.Application.model;

import javax.annotation.processing.Generated;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;


@Entity
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID= 1L;
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "O nome deve ser preenchido")
    @Length(max = 100, min = 3, message = "O campo nome deve ter no minimo 3 e maximo 100")
    private String name;
    @NotEmpty(message = "A descrição deve ser preenchido")
    @Length(min = 5, max = 200, message = "O campo deve ter minimo 5 e maximo de 200")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Book> books= new ArrayList<>();


    public Category() {

    }

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
