package com.BookStore.Application.controller.exceptionsController;

import com.BookStore.Application.controller.exceptionsController.FieldExceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StardarError{
    private List<FieldExceptions> errors= new ArrayList<>();

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldExceptions> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldExceptions(fieldName, message) ) ;
    }
}
