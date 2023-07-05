package com.BookStore.Application.exceptions;

public class ObjectNotfound extends RuntimeException{
    private  static final long serialVersionUID=1L;

    public ObjectNotfound(String message) {
        super(message);
    }

    public ObjectNotfound(Throwable cause) {
        super(cause);
    }
}
