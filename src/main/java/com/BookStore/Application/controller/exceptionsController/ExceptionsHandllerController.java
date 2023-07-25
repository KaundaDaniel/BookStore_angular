package com.BookStore.Application.controller.exceptionsController;


import com.BookStore.Application.exceptions.DataIntegrityException;
import com.BookStore.Application.exceptions.ObjectNotfound;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandllerController {
    @ExceptionHandler(ObjectNotfound.class)
    public ResponseEntity<StardarError> objectError(ObjectNotfound e, ServletRequest request){
    StardarError erros= new StardarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StardarError> dataIntegrety(DataIntegrityException e, ServletRequest request){
        StardarError erros= new StardarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StardarError> validationError(MethodArgumentNotValidException e, ServletRequest request){
        ValidationError erros= new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");
        for (FieldError x:e.getBindingResult().getFieldErrors()
             ) {
            erros.addErrors(x.getField(),x.getDefaultMessage());

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
