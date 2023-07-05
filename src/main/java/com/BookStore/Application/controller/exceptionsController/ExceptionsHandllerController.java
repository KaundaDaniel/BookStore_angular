package com.BookStore.Application.controller.exceptionsController;


import com.BookStore.Application.exceptions.ObjectNotfound;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandllerController {
    @ExceptionHandler(ObjectNotfound.class)
    public ResponseEntity<StardarError> objectError(ObjectNotfound e, ServletRequest request){
    StardarError erros= new StardarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    }
}
