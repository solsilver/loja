package com.br.nathan.Loja.controller.exception;

import com.br.nathan.Loja.service.exception.ItemDuplicado;
import com.br.nathan.Loja.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StantardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Validation Errors", System.currentTimeMillis());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StantardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StantardError error = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ItemDuplicado.class)
    public ResponseEntity<StantardError> objectNotFound(ItemDuplicado e, HttpServletRequest request) {
        StantardError error = new StantardError(HttpStatus.CONFLICT.value(),e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}