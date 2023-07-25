package com.BookStore.Application.controller.exceptionsController;

import java.io.Serializable;

public class FieldExceptions implements Serializable {
    private static final long   serialVersioUID=1L;
    private String fieldName;
    private String message;

    public FieldExceptions(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public FieldExceptions() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
