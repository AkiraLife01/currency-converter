package com.converter.currencyconverter.controller.advice;

import com.converter.currencyconverter.exception.LoginNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({ LoginNotFoundException.class})
    public ResponseEntity<?> loginNotFound() {
        return ResponseEntity
                .badRequest()
                .body("Login not found!");
    }
}
