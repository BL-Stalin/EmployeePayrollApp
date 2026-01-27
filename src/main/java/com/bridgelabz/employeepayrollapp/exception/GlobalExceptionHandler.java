package com.bridgelabz.employeepayrollapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ---- UC2-VALIDATION-ERROR ----
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    // ---- UC3-DATE-FORMAT-ERROR ----//
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleDateFormatException(
            HttpMessageNotReadableException ex) {

        return new ResponseEntity<>(
                "Invalid date format. Please use yyyy-MM-dd",
                HttpStatus.BAD_REQUEST
        );
    }
}
