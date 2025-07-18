package com.juntralala.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.xpath.XPath;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice()
public class ErrorController {

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Validation Error: " + e.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(exception = ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Validation Error: " + e.getMessage(), BAD_REQUEST);
    }

}
