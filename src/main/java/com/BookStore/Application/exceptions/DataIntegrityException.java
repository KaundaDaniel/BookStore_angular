package com.BookStore.Application.exceptions;

public class DataIntegrityException extends RuntimeException{
    private static final long serialVersioUID=1L;

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(Throwable cause) {
        super(cause);
    }
}
