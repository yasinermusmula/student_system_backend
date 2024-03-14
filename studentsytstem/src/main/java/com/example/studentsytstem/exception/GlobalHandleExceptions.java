package com.example.studentsytstem.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandleExceptions{

    @ExceptionHandler
    public ResponseEntity<ErrorResponseException> handleError (GlobalExceptions globalExceptions){

        ErrorResponseException errorResponseException = new ErrorResponseException(globalExceptions.getStatus().value(),
                globalExceptions.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseException,globalExceptions.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseException> handleError (Exception exception){

        ErrorResponseException errorResponseException = new ErrorResponseException(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseException,HttpStatus.BAD_REQUEST);
    }
}
