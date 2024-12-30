package com.restservices.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Get BindingResult from the exception
        BindingResult result = ex.getBindingResult();

        // Create a map to store error messages
        Map<String, String> errors = new HashMap<>();

        // Iterate over all the field errors and add them to the map
        for (FieldError error : result.getFieldErrors()) {
            // Add field name and error message to the map
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // Return the error map with BAD_REQUEST status (400)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle general exceptions (optional)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}