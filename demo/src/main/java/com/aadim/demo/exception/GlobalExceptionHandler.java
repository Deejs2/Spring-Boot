package com.aadim.demo.exception;

import com.aadim.demo.dto.GlobalErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalErrorResponse> handleValidations(MethodArgumentNotValidException ex){
        log.warn("Validation error");
        List<String> errorList = ex.getBindingResult().getAllErrors().stream()
        .map(error -> "Validation Failed For Field " + ((FieldError) error).getField()
            + ":" + error.getDefaultMessage())
        .toList();

        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(HttpStatus.BAD_REQUEST,errorList, "Failure");
        return new ResponseEntity<>(globalErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
