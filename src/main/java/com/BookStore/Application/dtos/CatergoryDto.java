package com.BookStore.Application.dtos;

import com.BookStore.Application.model.Category;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class CatergoryDto implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, max = 80, message = "O nome deve ser preenchido")
    private String name;
    @NotEmpty(message = "Não poder estar vazio")
    @Length(min = 3, max = 200, message = "O nome deve ser preenchido")
    private String description;
    public CatergoryDto() {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CatergoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
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
}
